package id.co.xl.checkbalancebj.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonRs {
    private String status;
    private String code;
    private String message;
    @JsonIgnore
    private HttpStatus httpStatus;
    @JsonIgnore
    private String exceptionDescription;

    public void setSuccess(String message) {
        this.httpStatus = HttpStatus.OK;
        this.status = ApplicationConstant.STATUS_OK;
        this.code = String.valueOf(httpStatus.value());
        this.message = message;
        this.exceptionDescription = null;
    }

    public void setInternalError(String exceptionDescription) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.status = ApplicationConstant.STATUS_ERROR;
        this.code = String.valueOf(httpStatus.value());
        this.message = "Internal server error";
        this.exceptionDescription = exceptionDescription;
    }
}
