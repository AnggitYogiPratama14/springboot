package com.herya.exception;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiFault {
    private Integer id;
    private String nama;
    private String nomor;
    private String sekolah;
    private String detail;

    public String getError(){
        return id + ":" + nama + ":" + nomor ":" + sekolah ":" + detail;
    }
}
