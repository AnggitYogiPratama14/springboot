package com.herya.config.properties;

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
    private String APP_NAME = "api-login.service";
    private int HTTP_CLIENT_TIMEOUT = 30000;
    private boolean SEND_LOG_RABBIT_MQ = true;
}
