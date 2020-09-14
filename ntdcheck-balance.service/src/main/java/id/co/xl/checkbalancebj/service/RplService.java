package id.co.xl.checkbalancebj.service;

import id.co.xl.checkbalancebj.config.properties.ServiceProperties;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.exception.definition.CommonException;
import id.co.xl.checkbalancebj.exception.handler.RPLRestErrorHandler;
import id.co.xl.checkbalancebj.model.request.RequestInfo;
import id.co.xl.checkbalancebj.model.rpl.request.Request;
import id.co.xl.checkbalancebj.model.rpl.response.BjDetail;
import id.co.xl.checkbalancebj.model.rpl.response.Response;
import id.co.xl.checkbalancebj.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class RplService {
    @Autowired
    @Qualifier(ApplicationConstant.BEAN_APP_CONFIG)
    private ServiceProperties serviceProperties;
    @Autowired
    @Qualifier(ApplicationConstant.BEAN_REST_TEMPLATE)
    private RestTemplate restTemplate;

    public Double getBalanceBJ(RequestInfo requestInfo, String msisdn, String denom) throws CommonException {
        log.info("[{}][{} - getBalanceBJ][START][{}]", requestInfo.getCorrelationId(), getClass().getSimpleName(), msisdn);
        Request request = new Request()
                .setAction(serviceProperties.getACTION_RPL_GETBALANCEBJ())
                .add("msisdn", msisdn)
                .add("denom", denom);
        List<BjDetail> data = post(requestInfo, request, new ParameterizedTypeReference<Response<List<BjDetail>>>() {
        });
        if (data != null && !data.isEmpty()) {
            return data.get(0).getDenomination();
        }
        throw new CommonException(getClass().getSimpleName(), "BusinessError", "Failed get denom " + denom);


    }

    /**
     * generic call to cm service
     * @param requestInfo       {@link RequestInfo}
     * @param request           {@link Request}
     * @param typeReference     {@link ParameterizedTypeReference}
     * @param <T>               output type
     * @return                  result
     * @throws CommonException      CmException
     */
    private <T> T post(RequestInfo requestInfo, Request request, ParameterizedTypeReference<Response<T>> typeReference)
            throws CommonException {
        log.info("[{}][RplService - post {}][START][{}]", requestInfo.getCorrelationId(), request.getAction(), request);
        ResponseEntity<Response<T>> response = restTemplate.exchange(serviceProperties.getBASE_RPL_URL(),
                HttpMethod.POST,
                CommonUtils.initRequest(requestInfo, request),
                typeReference);
        if (response.getBody() == null) {
            throw new CommonException(getClass().getSimpleName(), "SystemError", "Null Body");
        } else {
            log.info("[{}][RplService - post {}][SUCCESS][{}]", requestInfo.getCorrelationId(), request.getAction(), response.getBody());
            return response.getBody().getData();
        }
    }

    @PostConstruct
    void init() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        requestFactory.setReadTimeout(serviceProperties.getHTTP_CLIENT_TIMEOUT());
        restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new RPLRestErrorHandler());
    }
}
