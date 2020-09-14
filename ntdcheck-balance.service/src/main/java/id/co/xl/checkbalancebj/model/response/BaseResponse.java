package id.co.xl.checkbalancebj.model.response;


import id.co.xl.checkbalancebj.exception.definition.CommonException;

public interface BaseResponse {
    void setSuccess();
    void setSuccess(Object data);
    //void overrideException(ExceptionInfo exception);
    void setCommonException(CommonException commonException);
}
