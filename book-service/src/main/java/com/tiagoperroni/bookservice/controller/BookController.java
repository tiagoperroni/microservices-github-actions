package com.tiagoperroni.bookservice.controller;

import com.tiagoperroni.bookservice.model.Book;
import com.tiagoperroni.bookservice.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book-API")
@RestController
@RequestMapping("/book-service")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @Operation(summary = "Find a specific book for your ID")
    @GetMapping(value = "/{id}/{currency}")
    public ResponseEntity<Book> orderBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {       
       
        return new ResponseEntity<>(this.bookService.order(id, currency), HttpStatus.OK);
    }
}
