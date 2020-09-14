package id.co.xl.checkbalancebj.model.property;


import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private String exceptionCode;
    private String exceptionName;
    private String exceptionDescription;

    public void setSuccess() {
        this.exceptionCode = "00";
        this.exceptionName = ApplicationConstant.COMPLETION_STATUS_OK;
        this.exceptionDescription = ApplicationConstant.COMPLETION_STATUS_OK;
    }

    public void setSystemError (String exceptionDescription) {
        this.exceptionCode = "99";
        this.exceptionName = "INTERNAL_ERROR";
        this.exceptionDescription = exceptionDescription;
    }

    public void setInfo(String exceptionCode, String exceptionName, String exceptionDescription) {
        this.exceptionCode = exceptionCode;
        this.exceptionName = exceptionName;
        this.exceptionDescription = exceptionDescription;
    }
}
