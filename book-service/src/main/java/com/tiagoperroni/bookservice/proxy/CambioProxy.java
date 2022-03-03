package com.tiagoperroni.bookservice.proxy;

import com.tiagoperroni.bookservice.model.CambioResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "cambio-service", url = "localhost:8001")
@FeignClient(name = "cambio-service")
public interface CambioProxy {

    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public CambioResponse getCambio(@PathVariable Double amount, @PathVariable String from, @PathVariable String to);
    
}
