package com.herya.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties("jdbc")
public class JDBCProperties {
    private String DRIVER_CLASS_POSTGRESQL = "org.postgresql.Driver";
    private String URL_POSTGRESQL = "jdbc:postgresql://localhost:57879/dblogin";
    private String PASSWORD_POSTGRESQL = "admin";
    private String USERNAME_POSTGRESQL = "postgres";

}
