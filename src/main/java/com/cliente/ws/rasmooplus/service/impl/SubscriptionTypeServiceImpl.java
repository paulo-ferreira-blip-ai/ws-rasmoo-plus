package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.controller.SubcriptionTypeController;
import com.cliente.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.cliente.ws.rasmooplus.exception.BadRequestException;
import com.cliente.ws.rasmooplus.exception.NotFoundException;
import com.cliente.ws.rasmooplus.mapper.SubscriptionTypeMapping;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.cliente.ws.rasmooplus.service.SubcriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubcriptionTypeService {
    private static final String UPDATE = "update";
    private static final  String DELETE = "delete";
    @Autowired
    private SubscriptionTypeRepository subscriptionTypeRepository;
    @Override
    public List<SubscriptionType> findaAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findaById(Long id) {
        return getSubscriptionType(id).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubcriptionTypeController.class).findById(id))
                .withSelfRel()
        ).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubcriptionTypeController.class).update(id, new SubscriptionTypeDto()))
                .withRel(UPDATE)
        ).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubcriptionTypeController.class).delete(id))
                .withRel(DELETE)
        );

    }


    @Override
    public SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto){
        if (Objects.nonNull(subscriptionTypeDto.getId())){
            throw new BadRequestException("id deve ser nulo");
        }
        return subscriptionTypeRepository.save(SubscriptionType.builder() //método que faz mapeamento da classe dto para Model, isso por usar a anotação @Builde na classe
                .id(subscriptionTypeDto.getId())
                .name(subscriptionTypeDto.getName())
                .accessMonths(subscriptionTypeDto.getAccessMonths())
                .price(subscriptionTypeDto.getPrice())
                .productKey(subscriptionTypeDto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto subscriptionTypeDto) {
        getSubscriptionType(id);
        subscriptionTypeDto.setId(id);
        return subscriptionTypeRepository.save(SubscriptionTypeMapping.fromDtoToEntity(subscriptionTypeDto));
    }

    @Override
    public void delete(Long id) {
        getSubscriptionType(id);

        subscriptionTypeRepository.deleteById(id);

    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);

        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionType.get();
    }
}
