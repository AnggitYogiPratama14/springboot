package id.co.xl.checkbalancebj.model.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Balances {
    @JsonProperty("balances")
    private BalanceType balance;
}
