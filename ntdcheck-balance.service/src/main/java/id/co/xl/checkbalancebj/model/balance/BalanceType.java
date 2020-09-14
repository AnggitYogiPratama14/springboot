package id.co.xl.checkbalancebj.model.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BalanceType {
    @JsonProperty("PO")
    private PoType po;
    @JsonProperty("BJ")
    private List<BjType> bj;
}
