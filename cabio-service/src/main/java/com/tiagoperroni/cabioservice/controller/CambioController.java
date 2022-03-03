package com.tiagoperroni.cabioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.tiagoperroni.cabioservice.model.Cambio;
import com.tiagoperroni.cabioservice.repository.CambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository cambioRepository;

    @Operation(description = "Get cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> requestCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to) { 

        var cambio = cambioRepository.findByFromAndTo(from, to);
     
        if (cambio == null)
            throw new RuntimeException("Currency Unsupported!");

        var port = environment.getProperty("server.port");
        cambio.setEnvironment("Book-Service1 Port: " + port);

        BigDecimal convertionFactory = cambio.getConversionFactor();
        BigDecimal convertedValue = convertionFactory.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return new ResponseEntity<>(cambio, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cambio>> requestCambio() {
        return new ResponseEntity<>(this.cambioRepository.findAll(), HttpStatus.OK);
    }

}
