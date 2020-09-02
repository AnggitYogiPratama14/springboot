package com.herya.service;

import com.herya.model.TokoDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TokoServiceImpl implements TokoService {
    @Override
    public TokoDto getTokoById(UUID tokoId){
        return TokoDto.builder().id(UUID.randomUUID())
                .tokoName("Herya")
                .tokoStyle("mini")
                .build();
    }
}
