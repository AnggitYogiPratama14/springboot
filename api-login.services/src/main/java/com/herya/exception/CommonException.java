package com.herya.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonException extends Exception {
    private Integer id;
    private String nama;
    private String nomor;
    private String sekolah;

    public CommonException(Integer id, String nama, String nomor, String sekolah, String message){
        super(message);
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
        this.sekolah = sekolah;

    }

    public CommonException(Integer id, String nama, String nomor, String sekolah){
        super(sekolah);
        this.id =id;
        this.nama = nama;
        this.nomor = nomor;
        this.sekolah = sekolah;
    }

    public CommonException(Integer id, String nama, String nomor, String sekolah, Throwable cause{
        super(sekolah, cause);
        this.id =id;
        this.nama = nama;
        this.nomor = nomor;
        this.sekolah = sekolah;
    }

    public ApiFault getApiFault
}
