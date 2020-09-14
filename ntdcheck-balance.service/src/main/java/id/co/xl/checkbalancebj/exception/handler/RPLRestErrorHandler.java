package id.co.xl.checkbalancebj.exception.handler;

import com.google.gson.JsonSyntaxException;

import id.co.xl.checkbalancebj.exception.definition.CommonException;
import id.co.xl.checkbalancebj.model.rpl.response.Response;
import id.co.xl.checkbalancebj.util.CommonUtils;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RPLRestErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return !clientHttpResponse.getStatusCode().is2xxSuccessful();
    }

    @SneakyThrows
    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        String body = IOUtils.toString(clientHttpResponse.getBody(), StandardCharsets.UTF_8);
        log.error(clientHttpResponse.getStatusText() +  ":" + body);
        try {
            Response resp = CommonUtils.gson.fromJson(body, Response.class);
            String status = (resp.getStatus().equalsIgnoreCase("failed"))? "BusinessError": "SystemError";
            log.error("FAILED CALL RPL ADAPTER {}", resp.toString());
            throw new CommonException("RplService", status, "RplException: " + resp.getMessage());
        } catch (JsonSyntaxException e) {
            log.error("FAILED CALL RPL ADAPTER {}", body);
            throw new CommonException("RplService", "SystemError", "UnhandledRplException: " + body);
        }
    }
}
