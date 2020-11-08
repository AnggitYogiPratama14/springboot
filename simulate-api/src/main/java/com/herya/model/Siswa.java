package com.herya.model;

import javax.persistence.*;

@Entity
@Table(name = "opsi_bimbel")
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String siswabimbel;
    @Column(name = "email")
    private String email;
    @Column(name = "published")
    private boolean published;

    public Siswa(){

    }

    public Siswa(String siswabimbel, String email, boolean published) {
        this.siswabimbel = siswabimbel;
        this.email = email;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSiswabimbel() {
        return siswabimbel;
    }

    public void setSiswabimbel(String siswabimbel) {
        this.siswabimbel = siswabimbel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "id=" + id +
                ", name='" + siswabimbel + '\'' +
                ", email='" + email + '\'' +
                ", published=" + published +
                '}';
    }
}
