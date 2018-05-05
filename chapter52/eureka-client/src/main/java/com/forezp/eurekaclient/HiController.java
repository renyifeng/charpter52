package com.forezp.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String home(@RequestParam String name)
    {
        return "I am "+name+" my port is "+port;
    }
}
