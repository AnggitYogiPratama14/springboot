package com.herya.service;

import com.herya.model.TokoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class TokoServiceImpl implements TokoService {
    @Override
    public TokoDto getTokoById(UUID tokoId){
        return TokoDto.builder().id(UUID.randomUUID())
                .tokoName("Herya")
                .tokoStyle("mini")
                .build();
    }
    @Override
    public TokoDto saveNewToko(TokoDto tokoDto){
        return TokoDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
    @Override
    public void updateToko(UUID tokoId,TokoDto tokoDto){
        /*
        * todo impl - would add a real impl to update toko
        * */
    }

    @Override
    public void deleteToko(UUID tokoId){
        log.debug("deleting toko ....");
    }

}
