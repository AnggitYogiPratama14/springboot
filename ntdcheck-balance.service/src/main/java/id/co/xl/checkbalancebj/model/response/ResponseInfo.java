package id.co.xl.checkbalancebj.model.response;


import id.co.xl.checkbalancebj.exception.ApiFault;
import id.co.xl.checkbalancebj.exception.definition.CommonException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * generic response info
 * @author HENYS
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ResponseInfo {
    private BaseResponse body;
    private HttpStatus httpStatus;
    private HttpHeaders httpHeaders;
    private List<ApiFault> faults;

    /**
     * set success without set data
     */
    public void setSuccess() {
        this.httpStatus = HttpStatus.OK;
        body.setSuccess();
    }

    /**
     * set success with data
     * @param data  {@link Object} (generic)
     */
    public void setSuccess(Object data) {
        setSuccess();
        body.setSuccess(data);
    }


    /**
     * add common exception
     * @param e {@link CommonException}
     */
    public void addException(CommonException e) {
        if (this.faults == null) {
            this.faults = new ArrayList<>();
        }
        this.faults.add(e.getApiFault());
    }

    /**
     * set exception using java exception
     * @param e {@link Exception}
     */
    public void setException(Exception e) {
        if (e instanceof CommonException) {
            setCommonException((CommonException) e);
        } else {
            setCommonException(new CommonException("Unknown:"+e.getClass().getSimpleName(), "SystemError", e.getMessage()));
        }
    }

   /**
     * set response based on common exception
     * @param e     {@link CommonException}
     */
    public void setCommonException(CommonException e) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        body.setCommonException(e);
        addException(e);
    }

  /*  *//**
     * override response using exception info (use xl.lib.exception)
     * @param exception {@link ExceptionInfo}
     *//*
    public void overrideException(ExceptionInfo exception) {
        if (exception != null) {
            this.httpStatus = HttpStatus.valueOf(exception.getHttpCode());
            body.overrideException(exception);
        }
    }*/

    /**
     * check is error
     * @return  true/false
     */
  public boolean isError() {
        return (faults != null && !faults.isEmpty()) || !httpStatus.is2xxSuccessful();
    }

   /* *//*
     * get joined exception message
     * @return  exception message
     *//*
    public String getError() {
        if (faults != null && !faults.isEmpty()) {
            return StringUtils.join(getExceptionMessages(), ";");
        }
        return "00";
    }*/

   /* *//**
     * get list of exception message
     * @return  {@link List<String>}
     *//*
    public List<String> getExceptionMessages() {
        return faults.stream()
                .map(ApiFault::getError)
                .collect(Collectors.toList());
    }*/

    /**
     * add header
     * @param param     param
     * @param value     value
     */
    public void addHeader(String param, String value) {
        if (this.httpHeaders == null) {
            this.httpHeaders = new HttpHeaders();
        }
        this.httpHeaders.add(param, value);
    }
}
