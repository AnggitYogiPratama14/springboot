package id.co.xl.checkbalancebj.model.property;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CheckBj {
    private String payment_gateway;
    private String dealer;
    private String dealermsisdn;
    private String dealerid;
    private String pin;
    private String password;
}
