package com.herya.config.client;

import com.herya.config.properties.AppProperties;
import com.herya.config.variabel.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Autowired
    @Qualifier(ApplicationConstant.APP_CONFIG_NAME)
    private AppProperties appProperties;

    @Bean(ApplicationConstant.REST_TEMPLATE)
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory simple = new SimpleClientHttpRequestFactory();
        simple.setConnectTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        simple.setReadTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(simple);
        return new RestTemplate(factory);
    }

}
