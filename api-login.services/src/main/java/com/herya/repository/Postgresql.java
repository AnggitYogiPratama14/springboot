package com.herya.repository;

import com.herya.config.client.JdbcTemplate;
import com.herya.config.variabel.ApplicationConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Slf4j
public class Postgresql implements PostgresqlImpl{
    @Autowired
    @Qualifier(ApplicationConstant.JDBC_POSTGRESQL)
    private JdbcTemplate jdbcTemplate;

    /*public void insertApiLogin (Integer id, String nama, String nomor, String sekolah) throws DataIntegrityViolationException{
        try{
            String queryInsert = "INSERT INTO login(id, nama, nomor, sekolah)" +
                    "VALUES(nextval('nomor_sequence'), ?, ?,?)";
            jdbcTemplate.
        }
    }*/
    final String GET_API_LOGIN = "SELECT ID, NAMA, NOMOR, SEKOLAH, " +
            "FROM LOGIN" +
            "WHERE NOMOR = ?";
    final String INSERT_API_LOGIN = "INSERT INTO login(id, nama, nomor, sekolah)" +
            "VALUES(nextval('nomor_sequence'), ?, ?,?)";

    public
}
