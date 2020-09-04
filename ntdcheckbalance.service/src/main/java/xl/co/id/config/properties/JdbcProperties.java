package xl.co.id.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties("jdbc")
public class JdbcProperties {
    private String DRIVER_CLASS_ALOWXTR = "oracle.jdbc.OracleDriver";
    private String PASSWORD_ALLOWXTR = "XLUATCONF03123";
    private String URL_ALLOWXTR = "jdbc:oracle:thin:@//cbtgrdnblnp-scn.intra.excelcom.co.id:1522/SOADBDEV";
    private String USERNAME_ALLOWXTR = "XLUATCONF03";
}
