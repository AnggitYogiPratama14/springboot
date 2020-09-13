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
@ConfigurationProperties("app")

public class AppProperties {
    private String APP_NAME = "ntdcheck-balance.service";


    private String BASE_RPL_URL = "http://amdocs-rpl-sit.apps.cf-dev.intra.excelcom.co.id/v1/invoke";
    private String ACTION_RPL_GETBALANCE = "getRealBalance";
    private String ACTION_RPL_GETBALANCEBJ = "DenominationBalQuery";
    private String ACTION_RPL_GETDEALERPIN = "getDealerPin";
    private String ACTION_RPL_CHANGEDEALERPIN = "changePinDealer";

    private String BASE_DIA_URL = "http://amdocs-dia-sit.apps.cf-dev.intra.excelcom.co.id";

    private boolean SEND_LOG_RABBIT_MQ = true;
    private String ADAPTER_TIMEOUT = "UnhandledRplException";
    private String BALANCE_DENOM_LIST = "5000|10000";

    private int HTTP_CLIENT_TIMEOUT = 30000;
}
