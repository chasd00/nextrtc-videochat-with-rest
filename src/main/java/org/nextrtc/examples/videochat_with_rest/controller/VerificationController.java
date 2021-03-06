package org.nextrtc.examples.videochat_with_rest.controller;

import org.nextrtc.examples.videochat_with_rest.service.VerifyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/action")
public class VerificationController {

    @Autowired
    private VerifyUserService service;

    @RequestMapping(value = "verify/{key}", method = RequestMethod.GET)
    public String verify(@PathVariable String key) {

        service.verify(key);

        return "login";
    }
}
