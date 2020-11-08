package com.herya.usecase;

import com.herya.config.properties.AppProperties;
import com.herya.config.variabel.ApplicationConstant;
import com.herya.model.request.RequestInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BaseUsecase {
    @Autowired
    @Qualifier(ApplicationConstant.APP_CONFIG_NAME)
    private AppProperties appProperties;

    public void publish(RequestInfo)
}
