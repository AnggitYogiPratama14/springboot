package xl.co.id.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import xl.co.id.config.variable.ApplicationConstant;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {
    @Autowired
    @Qualifier(ApplicationConstant.BEAN_DATASOURCE_ALLOWXTR)
    private DataSource allowXtrDataSource;

    @Autowired
    @Qualifier(ApplicationConstant.BEAN_JDBC_ALLOWXTR)
    public JdbcTemplate initJdbcAllowXtr() {
        return new JdbcTemplate(allowXtrDataSource);
    }
}
