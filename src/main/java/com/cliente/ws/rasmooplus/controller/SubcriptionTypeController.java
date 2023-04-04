package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.service.SubcriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "subscription-type")
@Validated
public class SubcriptionTypeController {

    @Autowired
    private SubcriptionTypeService service;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findaAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findaById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto subscriptionTypeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(subscriptionTypeDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SubscriptionType> update(@PathVariable("id") Long id, @RequestBody SubscriptionTypeDto subscriptionTypeDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, subscriptionTypeDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

    }


}
