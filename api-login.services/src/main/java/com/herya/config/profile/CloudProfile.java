package com.herya.config.profile;

import com.herya.config.properties.AppProperties;
import com.herya.config.properties.JDBCProperties;
import com.herya.config.variabel.ApplicationConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Slf4j
@Configuration
@Profile({"dev","sit","stg","prod","cloud"})
public class CloudProfile {
    @Autowired
    private JDBCProperties jdbcProperties;

    @Bean(name = ApplicationConstant.APP_CONFIG_NAME)
    public AppProperties loadConfig(){
        return new AppProperties();
    }
    @Bean(name = ApplicationConstant.DATASOURCE_POSTGRESQL)
    public DataSource loadPostgresqlDatasource(){
       DriverManagerDataSource ds = new DriverManagerDataSource();
       ds.setDriverClassName(jdbcProperties.getDRIVER_CLASS_POSTGRESQL());
       ds.setUrl(jdbcProperties.getURL_POSTGRESQL());
       ds.setUsername(jdbcProperties.getUSERNAME_POSTGRESQL());
       ds.setPassword(jdbcProperties.getPASSWORD_POSTGRESQL());
       return ds;

    }

}
