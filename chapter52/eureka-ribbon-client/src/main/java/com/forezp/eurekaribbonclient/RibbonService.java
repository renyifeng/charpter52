package com.forezp.eurekaribbonclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String Hi(String name)
    {
        return restTemplate.getForObject("http://eureka-client1/hi?name="+name,String.class);
    }
    public String hiError(String name)
    {
        return "hi,"+name+",sorry,error!";
    }
}
