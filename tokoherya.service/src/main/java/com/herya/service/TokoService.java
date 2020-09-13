package com.herya.service;

import com.herya.model.TokoDto;

import java.util.UUID;

public interface TokoService {
    TokoDto getTokoById(UUID tokoId);

    TokoDto saveNewToko(TokoDto tokoDto);

    void updateToko(UUID tokoId,TokoDto tokoDto);

    void deleteToko(UUID tokoid);
}
