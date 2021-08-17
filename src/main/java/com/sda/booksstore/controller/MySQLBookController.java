package com.sda.booksstore.controller;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.service.MySQLBookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Profile("MySQL")

@RestController
@RequestMapping(value = "/books")
public class MySQLBookController {

    private final MySQLBookService mySQLBookService;

    @Autowired
    public MySQLBookController(MySQLBookService mySQLBookService) {
        this.mySQLBookService = mySQLBookService;
    }


    @Value("${spring.application.name}")
    private String appName;

    // GET - application name
    @GetMapping("/app")
    public String appName() {
        return appName;
    }

    // GET - all
    @GetMapping
    public List<Book> getAll() {
        return mySQLBookService.getAllBooks();
    }

}
