package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.dto.PaymentProcessDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.cliente.ws.rasmooplus.exception.BusinessException;
import com.cliente.ws.rasmooplus.exception.NotFoundException;
import com.cliente.ws.rasmooplus.integration.MailIntegration;
import com.cliente.ws.rasmooplus.integration.WsRaspayIntegration;
import com.cliente.ws.rasmooplus.mapper.UserPaymentInfoMapper;
import com.cliente.ws.rasmooplus.mapper.wsraspay.CreditCardMapper;
import com.cliente.ws.rasmooplus.mapper.wsraspay.CustomerMapper;
import com.cliente.ws.rasmooplus.mapper.wsraspay.OrderMapper;
import com.cliente.ws.rasmooplus.mapper.wsraspay.PaymentMapper;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserPaymentInfo;
import com.cliente.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.cliente.ws.rasmooplus.repository.UserRepository;
import com.cliente.ws.rasmooplus.service.PaymentInfoService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private final UserRepository userRepository;
    private final UserPaymentInfoRepository userPaymentInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;

    private final MailIntegration mailIntegration;

    PaymentInfoServiceImpl(UserRepository userRepository, UserPaymentInfoRepository userPaymentInfoRepository, WsRaspayIntegration wsRaspayIntegration, MailIntegration mailIntegration) {
        this.userRepository = userRepository;
        this.userPaymentInfoRepository = userPaymentInfoRepository;
        this.wsRaspayIntegration = wsRaspayIntegration;
        this.mailIntegration = mailIntegration;
    }

    @Override
    public Boolean process(PaymentProcessDto dto) {
        //verifica o usuario por id e verifica se já existe assinatura
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());

        if (userOpt.isEmpty()) {
            throw new NotFoundException("Usuario não encontrado");
        }

        User user = userOpt.get();
        if (Objects.nonNull(user.getSubscriptionType())) {
            throw new BusinessException("Pagamento não pode ser processado pois usuario ja possui assinatura");
        }

        //cria ou atualiza usuario raspay
        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));

        //cria o pedido de pagamento
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(),
                dto));

        //processa o pagamento
        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(),
                orderDto.getId(),
                CreditCardMapper.build(dto.getUserPaymentInfoDto(),
                        user.getCpf()));
        Boolean successPayment = wsRaspayIntegration.processPayment(paymentDto);

        if (Boolean.TRUE.equals(successPayment)) {
            //salvar informaçoes de pagamento no banco
            UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper
                    .fromDtoToEntity(dto
                            .getUserPaymentInfoDto(), user);
            userPaymentInfoRepository.save(userPaymentInfo);
            mailIntegration.send(user.getEmail(),
                    "Usuario: "
                            + user.getEmail() +
                            " - Senha: alunorasmooo",
                    "Acesso liberado!");
            return true;
        }


        //envio de confirmação de conta
        //retorna o sucesso ou nao do pagamento
        return false;
    }
}
