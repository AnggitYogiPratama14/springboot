package id.co.xl.checkbalancebj.config.profile;


import id.co.xl.checkbalancebj.config.properties.JdbcProperties;
import id.co.xl.checkbalancebj.config.properties.ServiceProperties;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("local")
public class LocalDataSourceConfig {

    @Autowired
    private JdbcProperties jdbcProperties;

    @Bean(ApplicationConstant.BEAN_APP_CONFIG)
    public ServiceProperties loadConfig() {
        return new ServiceProperties();
    }

    @Bean(ApplicationConstant.BEAN_DS_ALLOWXTR)
    public DataSource loadMasterDataDatasorce() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(jdbcProperties.getDRIVER_CLASS_ALOWXTR());
        ds.setUrl(jdbcProperties.getURL_ALLOWXTR());
        ds.setUsername(jdbcProperties.getUSERNAME_ALLOWXTR());
        ds.setPassword(jdbcProperties.getPASSWORD_ALLOWXTR());
        return ds;
    }

}




/*    @Bean(name = "soar-allowXtr")
    public DataSource allowXtrDatasource(){
        return createDataSource("jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV", "oracle.jdbc.OracleDriver", "XLUATCONF03",
                "XLUATCONF03123");

    }
    @Bean(name = "allowXtr")
    public JdbcTemplate allowXtrJdbcTemplate(@Qualifier("soar-allowXtr") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }*/




    /*@Bean(ApplicationConstant.BEAN_DS_ALLOWXTR)
    public DataSource allowxtrDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("oracle.jdbc.OracleDriver")
                .url("jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV")
                .username("XLUATCONF03")
                .password("XLUATCONF03123")
                .build();*/



   /* @Bean(ApplicationConstant.PROPERTY_GROUP)
    public LoggingProperties initLoggingProperties(){
        LoggingProperties prop = new LoggingProperties();
        prop.setCONN_MQ_HOST("572472e8-3c54-48f5-8dc3-d6b09b773841");
        prop.setCONN_MQ_USERNAME("3ae08450-f5bc-4b10-96ed-d4053039e0f1");
        prop.setCONN_MQ_PASSWORD("oE3iRmwjna_LPpxgBCY-Mfthwp9TONOq");
        prop.setCONN_MQ_PORT(5672);
        prop.setCONN_MQ_QUEUE("xl.pcf.rmq.logstash");
        return prop;
    }*/
   /* @Bean(id.co.xl.lib.logging.config.ApplicationConstant.PROP_NAME)
    public LoggingProperties initLoggingProperties() {
        return new LoggingProperties();
    }*/
/*
    // override properties for exception library
    @Bean(id.co.xl.lib.exception.config.ApplicationConstant.EXCEPTION_NAME)
    public List<ExceptionMap> initExceptionMapping() {
        return new ArrayList<>();
    }*/

