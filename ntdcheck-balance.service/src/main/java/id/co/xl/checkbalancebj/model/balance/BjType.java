package id.co.xl.checkbalancebj.model.balance;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BjType {
    private int denom;
    private int unit;
}
