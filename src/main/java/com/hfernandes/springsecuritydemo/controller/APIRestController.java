package com.hfernandes.springsecuritydemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class APIRestController {

    private static final Logger LOG = LoggerFactory.getLogger(APIRestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(Principal principal) {
        LOG.info("/api/test");
        //LOG.info("Username:{}", principal.getName());

        String response = "{\"status\":\"ok\"}";

        LOG.debug("Return: " + response);
        return response;
    }

}
