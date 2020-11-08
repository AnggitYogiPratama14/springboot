package com.herya.delivery;

import com.herya.usecase.ProfileUsecase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/check/v1")
public class CheckController {
    @Autowired
    private ProfileUsecase profileUsecase;
}
