package com.tiagoperroni.bookservice.service;

import java.util.HashMap;

import com.tiagoperroni.bookservice.model.Book;
import com.tiagoperroni.bookservice.model.CambioResponse;
import org.springframework.core.env.Environment;
import com.tiagoperroni.bookservice.proxy.CambioProxy;
import com.tiagoperroni.bookservice.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @Autowired
    private Environment environment;

    public Book order(Long id, String currency) {

        var book = this.bookRepository.getById(id);
        if (book == null) throw new RuntimeException("Book not found.");

        var cambio = this.getCambioFeign(book.getPrice(), currency);
        
        book.setEnvironment("Book-Service1 Port: " + environment.getProperty("server.port") + " " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());

        return book;
    }

    public CambioResponse getCambioFeign(Double amount, String currency) {
        var response = cambioProxy.getCambio(amount, "USD", currency);        
        return response;
    }

    public CambioResponse getCambio(Double amount, String currency) {
        var params = new HashMap<String, String>();
        params.put("amount", amount.toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate()
            .getForEntity("http://localhost:8001/cambio-service/{amount}/{from}/{to}", CambioResponse.class, params);
        
        return response.getBody();
    }    
}
