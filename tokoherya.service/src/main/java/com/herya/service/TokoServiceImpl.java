package com.herya.service;

import com.herya.model.TokoDto;

import java.util.UUID;

public class TokoServiceImpl implements TokoService {
    @Override
    public TokoDto getTokoById(UUID tokoId){
        return TokoDto.builder().id(UUID.randomUUID())
                .tokoName("Herya")
                .tokoStyle("mini")
                .build();
    }
}
