package com.sda.booksstore.controller;

import com.sda.booksstore.service.MySQLBookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Profile("MySQL")

@Controller
public class WebController {

    private final MySQLBookService mySQLBookService;

    public WebController(MySQLBookService mySQLBookService) {
        this.mySQLBookService = mySQLBookService;
    }

    // Runs "home.html" file  in browser from Thymeleaf templates directory
    // Transferring username as an attribute to another page
    @GetMapping(value = "/home")
    private String sayHello(@RequestParam(required = false) String login, Model model) {
        System.out.println("Username is: " + login);
        model.addAttribute("login", login);
        return "home";
    }

    // Runs "books_list.html" file  in browser from Thymeleaf templates directory
    // Showing all book in DB
    @GetMapping(value = "/books_list")
    public String getAllBooks(Model model) {
        System.out.println("Books list is active");
        model.addAttribute("allbooks", mySQLBookService.getAllBooks());
        return "books_list";
    }
}
