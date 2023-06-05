package com.cliente.ws.rasmooplus.mapper.wsraspay;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.model.User;

public class CustomerMapper {

    public static CustomerDto build(User user) {

        //O código divide o nome do usuário em caracteres individuais e atribui o primeiro
        // caractere à variável firstName e o último caractere (se houver) à variável lastName.

        //Essa linha divide o nome do usuário em um array de caracteres individuais.
        // O método split("") divide a string em cada caractere e retorna um array contendo esses caracteres.
        var fullName = user.getName().split("");
        // Essa linha atribui o primeiro elemento do array fullName à variável firstName. Nesse caso,
        // o primeiro elemento é o primeiro caractere do nome do usuário, representando o primeiro nome.
        var firstName = fullName[0];
        //Essa linha atribui o último elemento do array fullName à variável lastName, desde que o
        // tamanho do array seja maior que 1. Caso contrário, atribui uma string vazia (""). Essa
        // verificação é feita usando o operador ternário (? :). O último elemento do array fullName
        // representa o último caractere do nome do usuário, que, neste caso, é considerado como sobrenome.
        var lastName = fullName.length > 1 ? fullName[fullName.length - 1] : "";


        return CustomerDto.builder()
                .cpf(user.getCpf())
                .email(user.getEmail())
                .lastName(lastName)
                .firstName(firstName)
                .build();

    }
}
