package id.co.xl.checkbalancebj.config.variable;

import java.text.SimpleDateFormat;

public class ApplicationConstant {
    public static final String APP_NAME = "ntdcheck-balance.service";
    public static final String BEAN_APP_CONFIG = "app";
    public static final String PROPERTY_GROUP = "NTDCHECK-BALANCE";
    public static final String BEAN_DS_ALLOWXTR = "datasource-allowxtr";
    public static final String BEAN_JDBC_ALLOWXTR = "jdbc-allowxtr";
    public static final String BEAN_REST_TEMPLATE = "rest-template";
    public static final String DATETIME_ELKSFORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static SimpleDateFormat DATETIME_ELKFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");


    /*---------------------------------------------------------------------------------------*/
    public static final String STATUS_OK = "ok";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_ERROR = "error";

    public static final String COMPLETION_STATUS_OK = "Success";
    public static final String COMPLETION_STATUS_FAILED = "BusinessError";
    public static final String COMPLETION_STATUS_ERROR = "SystemError";

    // Request Header
    public static final String REGEX_UUID_VER4 = "\\b[0-9a-f]{8}\\b-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-\\b[0-9a-f]{12}\\b";
    public static final String REGEX_DATE_YYYYMMDD = "\\b[0-9]{4}\\b-[0-9]{2}-[0-9]{2}\\b";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String REGEX_MSISDN = "^[0-9]+$";
    public static final String REGEX_CAT_1 = "^[a-zA-Z]+$";
    public static final String REGEX_CAT_2 = "^[a-zA-Z0-9.]+$";
    public static final String REGEX_CAT_3 = "^[a-zA-Z0-9.-]+$";








    /*-----------------------------------------------------------------------------------*/

    public static final String BEAN_COMMON = "common-bean";
//    public static final String BEAN_JDBC_LOCAL = "jdbc-local";
//    public static final String BEAN_DATASOURCE_LOCAL = "datasource-local";


    public static final String CHANNEL = "UMB";
    public static final String UMB_CONFIG_NAME = "umb-config";



    public static final String UMB_NAMESPACE = "http://schemas.xl.co.id/UMBResponse/V1.0";



    //Error code
    public static final String EC01 = "ERR-01";
    public static final String EC02 = "ERR-02";
    public static final String EC03 = "ERR-03";
    public static final String EC04 = "ERR-04";
    public static final String EC05 = "ERR-05";
    public static final String EC06 = "ERR-06";
    public static final String EC07 = "ERR-07";
    public static final String EC08 = "ERR-08";
    public static final String EC09 = "ERR-09";
    public static final String EC10 = "ERR-10";
    public static final String EC11 = "ERR-11";
    public static final String EC99 = "ERR-99";

    //error
    public static final String ERR01 = "Required parameter is missing";
    public static final String ERR02 = "Not XL Number";
    public static final String ERR03 = "Input data failed validation";
    public static final String ERR04 = "Incomplete input parameter";
    public static final String ERR05 = "The consent id is not allowed to use this api";
    public static final String ERR06 = "Subscriber is not found";
    public static final String ERR07 = "Consent Id is not found";
    public static final String ERR08 = "Subsriber number is not match";
    public static final String ERR09 = "Subscriber user consent is not found";
    public static final String ERR10 = "Data is not found";
    public static final String ERR11 = "Device is not found";
    public static final String ERR99 = "Internal server error";


}
