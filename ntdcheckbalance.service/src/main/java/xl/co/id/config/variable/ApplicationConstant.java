package xl.co.id.config.variable;

import java.text.SimpleDateFormat;

public class ApplicationConstant {
    public static final String APP_NAME = "ntdcheck-balance.service";
    public static final String BEAN_APP_CONFIG = "appconf";
    public static final String PROPERTY_GROUP = "NTDCHECK-BALANCE";
    public static final String BEAN_DATASOURCE_ALLOWXTR = "datasource-allowxtr";
    public static final String BEAN_JDBC_ALLOWXTR = "jdbc-allowxtr";
    public static final String BEAN_REST_TEMPLATE = "rest-template";
    public static final String BEAN_COMMON = "common-bean";
    public static final String BEAN_JDBC_LOCAL = "jdbc-local";
    public static final String BEAN_DATASOURCE_LOCAL = "datasource-local";
    public static final String DATETIME_ELKSFORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";


    public static SimpleDateFormat DATETIME_ELKFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

}
