package id.co.xl.checkbalancebj.config.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("jdbc")
public class JdbcProperties {
    private String DRIVER_CLASS_ALOWXTR = "oracle.jdbc.OracleDriver";
    private String PASSWORD_ALLOWXTR = "XLUATCONF03123";
    private String URL_ALLOWXTR = "jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV";
    private String USERNAME_ALLOWXTR = "XLUATCONF03";
}
