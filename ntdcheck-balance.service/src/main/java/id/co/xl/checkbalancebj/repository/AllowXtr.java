package id.co.xl.checkbalancebj.repository;

import com.google.gson.Gson;
import id.co.xl.checkbalancebj.config.properties.ServiceProperties;
import id.co.xl.checkbalancebj.config.variable.ApplicationConstant;
import id.co.xl.checkbalancebj.exception.CommonEx;
import id.co.xl.checkbalancebj.model.property.CheckBj;
import id.co.xl.checkbalancebj.model.response.ProductRs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@Transactional
public class AllowXtr {

    public static Gson gson = new Gson();

    @Autowired
    ServiceProperties serviceProperties;


    @Qualifier(ApplicationConstant.BEAN_JDBC_ALLOWXTR)
    private JdbcTemplate jdbcTemplate;

    public ProductRs checkBalanceBj(String dealermsisdn, String password) throws  DataIntegrityViolationException{
        String query = "SELECT DEALER, DEALER_MSISDN, DEALER_PIN, PIN, PASSWORD FROM UPFRONT_MODERN_CHANNEL_WL WHERE DEALER_MSISDN = ? AND PASSWORD=?";
        return jdbcTemplate.queryForObject(query, new Object[]{dealermsisdn, password}, ((resultSet, rowNum) ->
                new ProductRs(
                        resultSet.getString("PAYMENT_GATEWAY"),
                        resultSet.getString("DEALER"),
                        resultSet.getString("DEALER_MSISDN"),
                        resultSet.getString("DEALER_ID"),
                        resultSet.getString("PIN"),
                        resultSet.getString("PASSWORD"))));
    }
}
