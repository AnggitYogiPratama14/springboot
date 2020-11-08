package xl.co.id.config.profile;

import id.co.xl.lib.logging.config.LoggingProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import xl.co.id.config.properties.AppProperties;
import xl.co.id.config.variable.ApplicationConstant;

import javax.sql.DataSource;
@Configuration
@Profile("local")
public class LocalProfile {
    @Bean(ApplicationConstant.BEAN_APP_CONFIG)
    public AppProperties loadConfig(){
        return new AppProperties();
    }

    @Bean(ApplicationConstant.BEAN_DATASOURCE_ALLOWXTR)
    public DataSource allowxtrDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("oracle.jdbc.OracleDriver")
                .url("jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV")
                .username("XLUATCONF03")
                .password("XLUATCONF03123")
                .build();
    }

    @Bean(ApplicationConstant.PROPERTY_GROUP)
    public LoggingProperties initLoggingProperties(){
        LoggingProperties prop = new LoggingProperties();
        prop.setCONN_MQ_HOST("572472e8-3c54-48f5-8dc3-d6b09b773841");
        prop.setCONN_MQ_USERNAME("3ae08450-f5bc-4b10-96ed-d4053039e0f1");
        prop.setCONN_MQ_PASSWORD("oE3iRmwjna_LPpxgBCY-Mfthwp9TONOq");
        prop.setCONN_MQ_PORT(5672);
        prop.setCONN_MQ_QUEUE("xl.pcf.rmq.logstash");
        return prop;
    }
}
