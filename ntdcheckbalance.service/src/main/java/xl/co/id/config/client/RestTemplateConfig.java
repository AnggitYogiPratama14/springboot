package xl.co.id.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import xl.co.id.config.properties.AppProperties;
import xl.co.id.config.variable.ApplicationConstant;

@Configuration
public class RestTemplateConfig {
    @Autowired
    @Qualifier(ApplicationConstant.BEAN_APP_CONFIG)
    private AppProperties appProperties;

    @Bean(ApplicationConstant.BEAN_REST_TEMPLATE)
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory simple = new SimpleClientHttpRequestFactory();
        simple.setConnectTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        simple.setReadTimeout(appProperties.getHTTP_CLIENT_TIMEOUT());
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(simple);
        return new RestTemplate(factory);
    }
}
