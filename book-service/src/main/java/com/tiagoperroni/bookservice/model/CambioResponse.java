package com.tiagoperroni.bookservice.model;

import lombok.Data;

@Data
public class CambioResponse {

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String environment;
    
}
