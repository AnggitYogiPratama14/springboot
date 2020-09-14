package id.co.xl.checkbalancebj.model.rpl.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
    private String action;
    private List<RequestParam> param;

    public Request add(String paramName, String paramValue) {
        addParam(paramName, paramValue);
        return this;
    }

    public void addParam(String paramName, String paramValue) {
        if (this.param == null) {
            param = new ArrayList<>();
        }

        this.param.add(RequestParam.builder()
                .paramname(paramName)
                .paramvalue(paramValue)
                .build());
    }

    /**
     * get param value, null if not exists
     * @param paramName param name
     * @return          param value
     */
    @JsonIgnore
    public String getParamValue(String paramName) {
        return getParamValue(paramName, null);
    }

    /**
     * get param value, with default value
     * @param paramName param name
     * @param def       default value
     * @return          param value
     */
    @JsonIgnore
    public String getParamValue(String paramName, String def) {
        Optional<RequestParam> paramPair = this.param.stream().filter(p -> p.getParamname().equals(paramName)).findFirst();
        return paramPair.map(RequestParam::getParamvalue).orElse(def);
    }
}
