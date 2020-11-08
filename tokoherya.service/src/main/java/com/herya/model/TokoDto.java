package com.herya.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokoDto {
    private UUID id;
    private String tokoName;
    private String tokoStyle;
    private Long upc;
}
