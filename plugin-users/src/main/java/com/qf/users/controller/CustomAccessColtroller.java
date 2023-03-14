package com.qf.users.controller;

import com.qf.users.service.CustomAccessService;
import com.qf.service.CustomAccessInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2023/2/26 12:10
 * @Author qinfei
 **/
@Slf4j
@RestController
public class CustomAccessColtroller {
    
    @Autowired
    private CustomAccessService customAccessService;
    @Autowired
    private CustomAccessInterface customAccessInterface;
    
    @GetMapping("/custom")
    public String custom() {
        return customAccessService.test("test");
    }

    @GetMapping("/access")
    public String access() {
        return customAccessInterface.customAccess(null).message;
    }
}
