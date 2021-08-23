package com.sda.booksstore.controller;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.service.MySQLBookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Profile("MySQL")

@Controller
public class WebController {

    private final MySQLBookService mySQLBookService;

    public WebController(MySQLBookService mySQLBookService) {
        this.mySQLBookService = mySQLBookService;
    }


    // Runs "books_list.html" file  in browser from Thymeleaf templates directory
    // Showing all book in DB
    @GetMapping("/books_list")
    public String getAllBooks(Model model) {
        model.addAttribute("all_books", mySQLBookService.getAllBooks());
        // Return "books_list.html" page
        return "books_list";
    }


    // This is showing new book form, creating empty Book object and mapping it to
    // Model "book" attribute
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        // Return "add_book.html" page
        return "add_book";
    }


    // This is saving New Book in database and also saving existing Book during Update
    // using hidden form input field containing bookId
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        // Save book to database
        mySQLBookService.saveBook(book);
        // Redirecting to "books_list.html" page
        return "redirect:/books_list";
    }


    // This is showing Book update form and data according to particular bookId
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long bookId, Model model) {
        // Get book from Service by bookId
        Book book = mySQLBookService.getBookById(bookId);
        // Set book as a Model attribute to pre-populate the form
        model.addAttribute("book", book);
        // Return "update_book.html" page
        return "update_book";
    }


    // This is deleting book from DataBase by "bookId"
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") Long bookId) {
        // Calling delete (remove) method from the Service
        mySQLBookService.removeBookById(bookId);
        // Redirecting to "books_list.html" page
        return "redirect:/books_list";
    }


}
