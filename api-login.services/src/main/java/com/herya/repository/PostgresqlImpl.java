package com.herya.repository;

import com.herya.exception.CommonException;
import com.herya.model.request.login.Login;

public interface PostgresqlImpl {
    Login getApiLogin(String nomor) throws CommonException;
}
