package com.sda.booksstore.controller;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.service.MySQLBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

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

    // GET - all books from DB
    @GetMapping
    public List<Book> getAll() {
        return mySQLBookService.getAllBooks();
    }

    // GET - Count all Books
    @GetMapping("/count")
    public String countAll() {
        return "There are " + mySQLBookService.countBooks() + " books in database.";
    }

    // POST - register new book in DB
    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        mySQLBookService.addNewBook(book);
    }

    // DELETE - Delete book by ID
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id) {
        mySQLBookService.removeBookById(id);
        System.out.printf("Book with an ID %s successfully removed \n", id);
    }

    // PUT - Update book - bookName or/and bookISBN
    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id,
                           @RequestParam(required = false) String bookName,
                           @RequestParam(required = false) Integer bookISBN) {
        mySQLBookService.updateBookById(id, bookName, bookISBN);
    }
}
