package id.co.xl.checkbalancebj.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.xl.checkbalancebj.exception.definition.CommonException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody implements BaseResponse{
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("data")
    private Object data;

    @Override
    public void setSuccess() {
        this.statusCode = 200;
        this.errorCode = "Success";
        this.errorMessage = "";
    }

    @Override
    public void setSuccess(Object data) {
        this.data = data;
        setSuccess();
    }

   /* @Override
    public void overrideException(ExceptionInfo exception) {
        if (exception.getStatus() != 0) {
            this.statusCode = exception.getStatus();
        }
        if (exception.getCode() != null) {
            this.errorCode = exception.getCode();
        }
        if (exception.getMessage() != null) {
            this.errorMessage = exception.getMessage();
        }
    }*/

    @Override
    public void setCommonException(CommonException e) {
        statusCode = 500;
        errorCode = "Internal Server Error";
        errorMessage = e.getMessage();
    }
}
