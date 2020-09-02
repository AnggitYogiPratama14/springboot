package com.herya.service;

import com.herya.model.TokoDto;

import java.util.UUID;

public interface TokoService {
    TokoDto getTokoById(UUID tokoId);
}
