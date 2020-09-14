package id.co.xl.checkbalancebj.exception;

import lombok.*;

/**
 * api fault
 * @author HENYS
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiFault {
    private String type;
    private String status;
    private String description;
    private String detail;

    public String getError() {
        return type + ":" + status + ":" + description + ":" + detail;
    }
}
