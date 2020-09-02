package com.herya.controller;

import com.herya.model.TokoDto;
import com.herya.service.TokoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/toko")
@RestController
public class TokoController {
    private final TokoService tokoService;

    public TokoController(TokoService tokoService){
        this.tokoService = tokoService;
    }
    @GetMapping({"/{tokoId}"})
    public ResponseEntity<TokoDto> getToko(@PathVariable("tokoId")UUID tokoId){
        return new ResponseEntity<>(tokoService.getTokoById(tokoId), HttpStatus.OK);
    }
}
