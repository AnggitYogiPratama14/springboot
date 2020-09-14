package id.co.xl.checkbalancebj.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayloadRs {

    private String status;
    private String code;
    private String message;
    private String transactionId;
    private String correlationId;
    private Object datas;
    @JsonIgnore
    private HttpStatus httpStatus;
    @JsonIgnore
    private HttpHeaders httpHeaders;

    public void setInternalErrorRs() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.status = ApplicationConstant.STATUS_ERROR;
        this.code = "99";
        this.message = "Internal server error";
        this.httpHeaders = setResponseHeader();
    }

    public void setSuccessRs() {
        this.httpStatus = HttpStatus.OK;
        this.status = ApplicationConstant.STATUS_OK;
        this.code = "00";
        this.message = ApplicationConstant.COMPLETION_STATUS_OK;
        this.httpHeaders = setResponseHeader();
    }

    public void setResponse(HttpStatus httpStatus, String status, String code, String message) {
        this.httpStatus = httpStatus;
        this.status = status;
        this.code = code;
        this.message = message;
        this.httpHeaders = setResponseHeader();
    }

    private HttpHeaders setResponseHeader () {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("response-at", ApplicationConstant.DATETIME_ELKFORMAT.format(new Date()));
        return httpHeaders;
    }
}
