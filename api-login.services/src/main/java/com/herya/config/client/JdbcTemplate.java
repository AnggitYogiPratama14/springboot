package com.herya.config.client;

import com.herya.config.variabel.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplate {
    @Autowired
    @Qualifier(ApplicationConstant.DATASOURCE_POSTGRESQL)
    private DataSource postgresqlDatasource;

    @Bean(ApplicationConstant.JDBC_POSTGRESQL)
    public JdbcTemplate initJdbcPostgresql(){
        return new JdbcTemplate(postgresqlDatasource);
    }
}
