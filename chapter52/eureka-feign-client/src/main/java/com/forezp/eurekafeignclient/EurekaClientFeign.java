package com.forezp.eurekafeignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value="eureka-client1",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping(value="/hi")
    String sayHiFromClientEureka(@RequestParam(value="name") String name);
}
