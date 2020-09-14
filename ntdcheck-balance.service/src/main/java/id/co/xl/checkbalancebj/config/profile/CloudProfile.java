/*
package id.co.xl.checkbalancebj.config.profile;


import id.co.xl.checkbalancebj.config.properties.ServiceProperties;
import id.co.xl.checkbalancebj.config.properties.JdbcProperties;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile({"dev", "sit", "stg", "prd"})
public class CloudProfile {
  */
/*  @Autowired
    private ServiceProperties serviceProperties;*//*

    @Autowired
    private JdbcProperties jdbcProperties;

    */
/*@Bean(ApplicationConstant.BEAN_APP_CONFIG)
    public ServiceProperties loadConfig(){
        return serviceProperties;
    }*//*


    @Bean(name = "soar-allowXtr")
    public DataSource loadAllowxtrDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDRIVER_CLASS_ALOWXTR());
        dataSource.setUrl(jdbcProperties.getURL_ALLOWXTR());
        dataSource.setUsername(jdbcProperties.getUSERNAME_ALLOWXTR());
        dataSource.setPassword(jdbcProperties.getPASSWORD_ALLOWXTR());
        return dataSource;
    }

    @Bean(name = "allowXtr")
    public JdbcTemplate allowXtrJdbcTemplate(@Qualifier("soar-allowXtr") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
*/
