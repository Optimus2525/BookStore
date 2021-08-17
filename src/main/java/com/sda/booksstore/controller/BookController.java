package com.sda.booksstore.controller;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Profile("default")

@RequiredArgsConstructor

@RestController
@RequestMapping(value = "/books", produces = APPLICATION_JSON_VALUE)
public class BookController {

    private final BookService service;

    @Value("${spring.application.name}")
    private String appName;

    // POST
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book create(@Valid @RequestBody Book book) {

        return service.saveBook(book);
    }

    // GET - all
    @GetMapping
    public Collection<Book> getAll() {
        return service.getAllBooks();
    }

    // GET - application name
    @GetMapping("/app")
    public String appName() {
        return appName;
    }

    // GET by id
    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    // GET by ISBN
    @GetMapping("/isbn/{isbn}")
    public Book getByISBN(@PathVariable("isbn") Integer bookISBN) {
        return service.getByISBN(bookISBN);
    }

    // GET by author
    @GetMapping("/author/{author}")
    public Book getByAuthor(@PathVariable("author") String bookAuthor) {
        return service.getByAuthor(bookAuthor);
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        service.removeBookById(id);
        return "Book successfully deleted";
    }

    // DELETE by ISBN
    @DeleteMapping("/isbn/{isbn}")
    public String deleteByISBN(@PathVariable("isbn") Integer isbn) {
        service.removeBookByISBN(isbn);
        return "Bok successfully deleted";
    }

    @PutMapping("/{id}")
    public Book updateBook(@Valid @PathVariable("id") Long id, @RequestBody Book book) {
        return service.update(book, id);
    }

    // //books?name=john&isbn=isbn
    @GetMapping("/{filter/{name}")
    public Collection<Book> getFiltered(@PathVariable("filter")
                                        @RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "isbn", required = false) Integer isbn) {
        return service.getAllAndFilter(name, isbn);
    }

}
