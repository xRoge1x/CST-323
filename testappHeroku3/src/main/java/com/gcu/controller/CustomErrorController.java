package com.gcu.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_MAPPING = "/error";

    @RequestMapping(ERROR_MAPPING)
    public String handleError() {
        return "error404";
    }

    public String getErrorPath() {
        return ERROR_MAPPING;
    }
}
