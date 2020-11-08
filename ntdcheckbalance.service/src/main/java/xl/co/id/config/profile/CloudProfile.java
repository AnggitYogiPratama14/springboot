package xl.co.id.config.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import xl.co.id.config.properties.AppProperties;
import xl.co.id.config.properties.JdbcProperties;
import xl.co.id.config.variable.ApplicationConstant;

import javax.sql.DataSource;
@Configuration
@Profile({"dev", "sit", "stg", "prd"})
public class CloudProfile {
    @Autowired
    private AppProperties appProperties;
    @Autowired
    private JdbcProperties jdbcProperties;

    @Bean(ApplicationConstant.BEAN_APP_CONFIG)
    public AppProperties loadConfig(){
        return appProperties;
    }

    @Bean(ApplicationConstant.BEAN_DATASOURCE_ALLOWXTR)
    public DataSource loadAllowxtrDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDRIVER_CLASS_ALOWXTR());
        dataSource.setUrl(jdbcProperties.getURL_ALLOWXTR());
        dataSource.setUsername(jdbcProperties.getUSERNAME_ALLOWXTR());
        dataSource.setPassword(jdbcProperties.getPASSWORD_ALLOWXTR());
        return dataSource;
    }


}
