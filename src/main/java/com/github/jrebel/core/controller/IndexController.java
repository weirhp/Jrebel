package com.github.jrebel.core.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.jrebel.core.util.RandomUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@RestController
public class IndexController {

    @RequestMapping({"/", ""})
    @SneakyThrows
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        String licenseUrl = System.getenv().getOrDefault("licenseUrl", request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()));
        String protocol = System.getenv().getOrDefault("protocol", "http://");


        return new ModelAndView("index", new HashMap<String, Object>() {{
            put("licenseUrl", licenseUrl);
            put("protocol", protocol);
            put("uuid", UUID.randomUUID().toString());
            put("mail", "%s@qq.com".formatted(RandomUtil.next(10000, 999999999)));
        }});
    }


}
