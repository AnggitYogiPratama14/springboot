package id.co.xl.checkbalancebj.util;

import com.google.gson.Gson;

import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.model.request.RequestInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@Slf4j
public class CommonUtils {
    public static Gson gson = new Gson();

    public static RequestInfo constructRequestInfo(String operation,
                                                   String requestId,
                                                   String channel,
                                                   String requestDate,
                                                   String password,
                                                   String dealermsisdn){
        ZonedDateTime start = ZonedDateTime.now();
        requestId = (requestId == null)? String.valueOf(UUID.randomUUID()) : requestId;
        requestDate = (requestDate == null)? start.toString().replace("[GMT+07:00]", ""): requestDate;

        return RequestInfo.newBuilder()
                .startTime(start.toString().replace("[GMT+07:00]", ""))
                .startTimestamp(start.toInstant().toEpochMilli())
                .serviceName(ApplicationConstant.APP_NAME)
                .operationName(operation)
                .channel(channel)
                .requestId(requestId)
                .requestDate(requestDate)
                .dealer_msisdn(dealermsisdn)
                .password(password)
                .build();
    }

























  /*  {
        if (servletRequest != null) {
            Map<String, String> headerMap = new HashMap<>();
            Enumeration<String> headerNames = servletRequest.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = servletRequest.getHeader(key);
                headerMap.put(key, value);
            }
            ZonedDateTime start = ZonedDateTime.now();
            requestId = (requestId == null)? String.valueOf(UUID.randomUUID()) : requestId;
            requestDate = (requestDate == null)? start.toString().replace("[GMT+07:00]", ""): requestDate;

            return RequestInfo.newBuilder()
                    .appName(ApplicationConstant.APP_NAME)
                    .operationName(operation)
                    .dealer_msisdn(dealermsisdn)
                    .password(password)
                    .channel(channel)
                    .requestId(requestId)
                    .requestDate(requestDate)
                    .build();

        } else {
            return RequestInfo.newBuilder()
                    .appName(ApplicationConstant.APP_NAME)
                    .operationName(operation)
                    .dealer_msisdn(dealermsisdn)
                    .password(password)
                    .channel(channel)
                    .requestId(requestId)
                    .requestDate(requestDate)
                    .build();
        }
    }*/

    public static String formatElkDate(Date date){
        return ApplicationConstant.DATETIME_ELKFORMAT.format(date);
    }

    /*ublic static String getErrorMessage(String exceptionString, Throwable throwable) {
        try {
            HttpJms httpJms = gson.fromJson(exceptionString, HttpJms.class);
            String code = httpJms.getParamValue("ExceptionCode");
            String name = httpJms.getParamValue("ExceptionName");
            String trace = httpJms.getParamValue("ExceptionDescription");

            return "ERR:" + httpJms.getAction() + ":" + code + ":" + name + ":" + trace;
        } catch (Exception eX) {
            log.warn("[FAILED PARSE BODY]");
        }
        return throwable.getMessage();
    }

    public static boolean isValidIdex(IdexProfileRs idexProfileRs) {
        if (idexProfileRs != null) {
            if (idexProfileRs.getBody() != null) {
                if (idexProfileRs.getBody().getResults() != null) {
                    return idexProfileRs.getBody().getResults().size() > 0;
                }
            }
        }
        return false;
    }

    public static ProfileResultRs getIdexProfileResult(IdexProfileRs idexProfileRs, String msisdn) {
        if (isValidIdex(idexProfileRs)) {
            Optional<ProfileResultRs> resultRs = idexProfileRs.getBody()
                    .getResults()
                    .stream()
                    .filter(it -> it.getRoMsisdn().equals(msisdn))
                    .findFirst();

            if (resultRs.isPresent()) {
                return resultRs.get();
            }
        }
        return null;
    }
*/
    public static String getExceptionString(Exception e) {
        if (e instanceof NoSuchPaddingException ||
                e instanceof NoSuchAlgorithmException ||
                e instanceof InvalidKeyException ||
                e instanceof BadPaddingException ||
                e instanceof IllegalBlockSizeException ||
                e instanceof IllegalArgumentException) {
            return "Failed Encryption:" + e.getMessage();
        }
        return e.getMessage();
    }

    public static String parseDate(Date date) {
        return parseDate(date, ApplicationConstant.DATETIME_ELKSFORMAT);
    }

    public static String parseDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static HttpEntity<?> initRequest(RequestInfo requestInfo, Object request) {
        if (request != null) {
            return new HttpEntity<>(request, generateHeader(requestInfo));
        } else {
            return new HttpEntity<>(generateHeader(requestInfo));
        }
    }

    public static HttpHeaders generateHeader(RequestInfo requestInfo) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ax-request-id", requestInfo.getCorrelationId());
        headers.set("ax-request-date", CommonUtils.parseDate(new Date()));
        headers.set("channel", StringUtils.defaultString(requestInfo.getChannel(), "TOKOXL"));
        return headers;
    }


}
