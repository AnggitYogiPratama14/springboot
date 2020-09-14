package id.co.xl.checkbalancebj.model.request;

import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.model.property.ErrorDetails;
import id.co.xl.checkbalancebj.model.response.CommonRs;
import id.co.xl.checkbalancebj.model.response.PayloadRs;
import id.co.xl.checkbalancebj.model.response.ResponseInfo;
import id.co.xl.checkbalancebj.util.CommonUtils;
import id.co.xl.lib.logging.model.LogRq;
import lombok.*;
import org.springframework.http.HttpHeaders;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestInfo extends LogRq {
    private String dealer_msisdn;
    private String password;
    private String exceptionDescription;
    private String response;
    private String requestDate;
    private int httpResponseCode;
    private String starTime;
    private String serviceName;
    private Long startTimestamp;

    @Builder(builderMethodName = "newBuilder")
    public RequestInfo(String appName, String operationName,String startTime, Long startTimestamp, String serviceName, String uri, String method, String touchpoint, String channel,
                       String host, String instanceId, String requestId, Date requestAt, Date requestEnd, String correlationId,
                       long duration, String completionStatus, Object errorDetails, String queryParam, Object requestHeaders,
                       Object requestPayload, Object responseHeaders, Object responsePayload, Object miscellaneous,
                       String statusCode, String dealer_msisdn, String password, String exceptionDescription, String response, int httpResponseCode,
                       String requestDate) {
        super(appName, operationName, uri, method, touchpoint, channel, host, instanceId, requestId, requestAt, requestEnd,
                correlationId, duration, completionStatus, errorDetails, queryParam, requestHeaders, requestPayload, responseHeaders, responsePayload, miscellaneous, statusCode);
        this.dealer_msisdn = dealer_msisdn;
        this.password = password;
        this.exceptionDescription = exceptionDescription;
        this.response = response;
        this.httpResponseCode = httpResponseCode;
        this.requestDate=requestDate;
        this.starTime = startTime;
        this.startTimestamp = startTimestamp;
        this.serviceName = serviceName;
    }

    public void setCommonRs(PayloadRs payloadRs, ErrorDetails errorDetails) {
        super.setCompletionStatus(ApplicationConstant.COMPLETION_STATUS_OK);
        if (!payloadRs.getCode().equals("00")) {
            super.setErrorDetails(errorDetails);
            if (payloadRs.getStatus().equals(ApplicationConstant.STATUS_ERROR)) {
                super.setCompletionStatus(ApplicationConstant.COMPLETION_STATUS_ERROR);
            } else {
                super.setCompletionStatus(ApplicationConstant.COMPLETION_STATUS_FAILED);
            }
        }
        super.setResponsePayload(payloadRs);
        super.setStatusCode(String.valueOf(payloadRs.getHttpStatus().value()));
    }

    public void setCommonRs(CommonRs commonRs) {
        super.setCompletionStatus("Success");
        if (commonRs.getExceptionDescription() != null) {
            this.exceptionDescription = commonRs.getExceptionDescription();
            if (commonRs.getHttpStatus().is5xxServerError()) {
                super.setCompletionStatus("SystemError");
            } else {
                super.setCompletionStatus("BusinessError");
            }
        }
        this.response = CommonUtils.gson.toJson(commonRs);
        this.httpResponseCode = commonRs.getHttpStatus().value();
    }


    public void setResponseHeaders (HttpHeaders headers) {
        super.setResponseHeaders(headers);
    }

    /**
     * set response info
     * @param responseInfo  {@link ResponseInfo}
     */
    public void setResponse(ResponseInfo responseInfo) {
        super.setCompletionStatus("Success");
        if (responseInfo.isError()) {
            super.setErrorDetails(responseInfo.getFaults());
            if (responseInfo.getHttpStatus().is5xxServerError()) {
                super.setCompletionStatus("SystemError");
            } else {
                super.setCompletionStatus("BusinessError");
            }
        }
        super.setErrorDetails(responseInfo.getFaults());
        super.setResponsePayload(responseInfo.getBody());
        super.setResponseHeaders(responseInfo.getHttpHeaders());
        super.setRequestEnd(Calendar.getInstance().getTime());
        super.setStatusCode(String.valueOf(responseInfo.getHttpStatus().value()));
    }
}
