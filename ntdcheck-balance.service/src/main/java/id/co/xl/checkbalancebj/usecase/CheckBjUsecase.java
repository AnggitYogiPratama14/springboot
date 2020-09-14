package id.co.xl.checkbalancebj.usecase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.exception.CommonEx;
import id.co.xl.checkbalancebj.model.property.CheckBj;
import id.co.xl.checkbalancebj.model.property.ErrorDetails;
import id.co.xl.checkbalancebj.model.request.CheckBalanceBjRq;
import id.co.xl.checkbalancebj.model.request.RequestInfo;
import id.co.xl.checkbalancebj.model.response.CommonRs;
import id.co.xl.checkbalancebj.model.response.GenericResponse;
import id.co.xl.checkbalancebj.model.response.PayloadRs;
import id.co.xl.checkbalancebj.model.response.ProductRs;
import id.co.xl.checkbalancebj.repository.AllowXtr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CheckBjUsecase {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    AllowXtr allowXtr;

    public GenericResponse<ProductRs> getBjBalance(String dealermsisdn, String password, RequestInfo requestInfo){
        log.info("[GET PARTNER:{}:{}:{}]", requestInfo.getOperationName(), dealermsisdn, password);
        ProductRs productRs = new ProductRs();
        GenericResponse<ProductRs> response = new GenericResponse<>();
        CommonRs commonRs = new CommonRs();
        try{
            productRs = allowXtr.checkBalanceBj(dealermsisdn, password);
            response.setData(productRs);
            response.setSuccess("Success");
            commonRs.setSuccess("Success");
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            response.setData(productRs);
            response.setSuccess("Success");
            commonRs.setSuccess("Success");
        } catch (Exception e){
            e.printStackTrace();
            commonRs.setInternalError(e.getMessage());
            response.setInternalError(e.getMessage());
        }
        requestInfo.setCommonRs(commonRs);
        return response;
    }





   /* public PayloadRs getCheckBj (String name, String value, RequestInfo requestInfo){
        PayloadRs payloadRs = PayloadRs.builder().correlationId(requestInfo.getCorrelationId()).transactionId(requestInfo.getRequestId()).build();
        ErrorDetails errorDetails = new ErrorDetails();
        try {
            switch (name.toUpperCase()) {
                case "DEALER_MSISDN":

                    //=========== QUERY CHECK STATUS
                    log.info("[QUERY CHECK STATUS BY DEALER_MSISDN][{}][{}]", requestInfo.getCorrelationId(), name, value);
                    payloadRs.setDatas(allowXtr.checkBalanceBj(value));

                    //===========
                    payloadRs.setSuccessRs();
                    break;
            }
        }*//*catch (CommonEx e){
            e.printStackTrace();
            HttpStatus httpStatus =HttpStatus.BAD_REQUEST;
            String message = e.getMessage();
            if (e.getStatus().equals(ApplicationConstant.STATUS_ERROR)){
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                message = "Internal Server Error";
            }
            payloadRs.setResponse(httpStatus, e.getStatus(), e.getExceptionCode(), message);
            errorDetails.setInfo(e.getExceptionCode(), e.getExceptionName(), e.getMessage());
        }*//* finally {

        }
        requestInfo.setCommonRs(payloadRs, errorDetails);
        return payloadRs;
    }*/

}
