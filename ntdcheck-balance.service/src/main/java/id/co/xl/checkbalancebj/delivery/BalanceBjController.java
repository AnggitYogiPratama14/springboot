package id.co.xl.checkbalancebj.delivery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.model.CommonBean;
import id.co.xl.checkbalancebj.model.request.CheckBalanceBjRq;
import id.co.xl.checkbalancebj.model.request.RequestInfo;
import id.co.xl.checkbalancebj.model.response.*;
import id.co.xl.checkbalancebj.usecase.CheckBjUsecase;
import id.co.xl.checkbalancebj.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/check")
@Validated
public class BalanceBjController {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    CheckBjUsecase checkBjUsecase;

   @RequestMapping(value = "/v1/balancebj", method = RequestMethod.GET)
    public ResponseEntity<?> checkBj(
                                     @RequestParam(value = "dealermsisdn") String dealermsisdn,
                                     @RequestParam(value = "password") String password,
                                     @RequestHeader(value = "channel", required = false) @Size(max = 32) @Pattern(regexp = ApplicationConstant.REGEX_CAT_1) String channel,
                                     @RequestHeader(value = "ax-request-id", required = false) @Size(max = 40) @Pattern(regexp = ApplicationConstant.REGEX_CAT_3) String requestId,
                                     @RequestHeader(value = "ax-request-at", required = false) @DateTimeFormat(pattern = ApplicationConstant.DATE_TIME_FORMAT) String requestDate){
    log.info("----- REQUEST RECEIVE ----- [{}][{}][{}][{}][{}]", channel, requestId, requestDate, dealermsisdn, password);
    RequestInfo requestInfo = CommonUtils.constructRequestInfo("getcheckbalance", requestId, channel, requestDate, password, dealermsisdn);
    GenericResponse<ProductRs> response = checkBjUsecase.getBjBalance(dealermsisdn, password, requestInfo);
   log.info("------- REQUEST COMPLETE ------- [{}][{}]\n{}", requestInfo.getCorrelationId(), requestInfo.getOperationName(), gson.toJson(response));
    return new ResponseEntity<>(response, response.getHttpStatus());
}

}
