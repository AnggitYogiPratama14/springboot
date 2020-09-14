package id.co.xl.checkbalancebj.config.client;


import id.co.xl.checkbalancebj.config.properties.ServiceProperties;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
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
    ServiceProperties serviceProperties;

    @Bean(ApplicationConstant.BEAN_REST_TEMPLATE)
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        requestFactory.setReadTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        return new RestTemplate(requestFactory);
    }

}
















/*----------------------------------------------------------*/
/*@Autowired
    @Qualifier(ApplicationConstant.BEAN_APP_CONFIG)
    private ServiceProperties serviceProperties;

    @Bean(ApplicationConstant.BEAN_REST_TEMPLATE)
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory simple = new SimpleClientHttpRequestFactory();
        simple.setConnectTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        simple.setReadTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(simple);
        return new RestTemplate(factory);
    }*/