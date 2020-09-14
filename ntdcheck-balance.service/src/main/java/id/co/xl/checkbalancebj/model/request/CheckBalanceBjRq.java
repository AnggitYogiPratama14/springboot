package id.co.xl.checkbalancebj.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class CheckBalanceBjRq {
    private String dealermsisdn;
    private String password;
}
