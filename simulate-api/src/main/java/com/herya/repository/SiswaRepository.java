package com.herya.repository;

import com.herya.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiswaRepository extends JpaRepository<Siswa, Long> {
    List<Siswa> findByPublished(boolean published);
    List<Siswa> findBySiswabimbelContaining(String siswabimbel);
}
