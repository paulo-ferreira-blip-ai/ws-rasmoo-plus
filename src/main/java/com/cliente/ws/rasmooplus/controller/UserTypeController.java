package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.dto.UserTypeDto;
import com.cliente.ws.rasmooplus.model.UserType;
import com.cliente.ws.rasmooplus.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "user-type")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @PostMapping
    public ResponseEntity<UserType> create(@Valid @RequestBody UserTypeDto userTypeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userTypeService.create(userTypeDto));
    }

    @GetMapping
    public ResponseEntity<List<UserType>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userTypeService.findAll());
    }
}
