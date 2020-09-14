package id.co.xl.checkbalancebj.exception.definition;


import id.co.xl.checkbalancebj.exception.ApiFault;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonException extends Exception {
    private String type;
    private String status;
    private String description;

    public CommonException(String type, String status, String description, String message) {
        super(message);
        this.type = type;
        this.status = status;
        this.description = description;
    }

    public CommonException(String type, String status, String description) {
        super(description);
        this.type = type;
        this.status = status;
        this.description = description;
    }

    public CommonException(String type, String status, String description, Throwable cause) {
        super(description, cause);
        this.type = type;
        this.status = status;
        this.description = description;
    }

   public ApiFault getApiFault() {
        return ApiFault.builder()
                .type(type)
                .status(status)
                .description(description)
                .detail(getMessage())
                .build();
    }
}
