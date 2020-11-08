package com.herya.config.profile;

import com.herya.config.properties.AppProperties;
import com.herya.config.properties.JDBCProperties;
import com.herya.config.variabel.ApplicationConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("local")
public class LocalProfil {
    @Autowired
    private JDBCProperties jdbcProperties;

    @Bean(ApplicationConstant.APP_CONFIG_NAME)
    public AppProperties loadconfig(){
        return new AppProperties();
    }
    @Bean(ApplicationConstant.DATASOURCE_POSTGRESQL)
    private DataSource loadPostgresqlDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:57879/dblogin");
        ds.setUsername("postgres");
        ds.setPassword("admin");
        return ds;
    }
}
