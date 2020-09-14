package id.co.xl.checkbalancebj.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRs {
    private String payment_gateway;
    private String dealer;
    private String dealer_msisdn;
    private String dealer_id;
    private String pin;
    private String password;

}
