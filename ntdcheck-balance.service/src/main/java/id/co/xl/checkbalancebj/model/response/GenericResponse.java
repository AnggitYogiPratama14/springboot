package id.co.xl.checkbalancebj.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> extends CommonRs {
    private T data;

    public GenericResponse(String status, String code, String message, HttpStatus httpStatus, String exceptionDescription, T data) {
        super(status, code, message, httpStatus, exceptionDescription);
        this.data = data;
    }
}
