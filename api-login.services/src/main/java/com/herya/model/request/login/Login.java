package com.herya.model.request.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Login {
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("nomor")
    private String nomor;
    @JsonProperty("sekolah")
    private String sekolah;
}
