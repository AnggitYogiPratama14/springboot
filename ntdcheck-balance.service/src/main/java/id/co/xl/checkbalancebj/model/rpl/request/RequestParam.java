package id.co.xl.checkbalancebj.model.rpl.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestParam {
    private String paramname;
    private String paramvalue;
}
