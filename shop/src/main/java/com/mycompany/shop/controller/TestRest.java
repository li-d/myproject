package com.mycompany.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.common.until.*;

@RestController
public class TestRest {

    @RequestMapping(value = "test")
    public String getTest() {
        StringHelper.isBlack("");
        return "ok";
    }
}
