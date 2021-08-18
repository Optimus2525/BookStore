package com.sda.booksstore.service;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.MySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("MySQL")
@Service
public class MySQLBookService {

    private final MySQLRepository mySQLRepository;

    @Autowired
    public MySQLBookService(MySQLRepository mySQLRepository) {
        this.mySQLRepository = mySQLRepository;
    }

    // This is fetching all data from DB into list using JpaRepository class
    // Get all Books from DB
    public List<Book> getAllBooks() {
        return mySQLRepository.findAll();
    }

    // This is counting (records) books in DB
    public Long countBooks() {
        return mySQLRepository.count();
    }

    // This is checking if there is a book with new ISBN code present in DB
    // If ISBN is present, an exception is thrown
    // If ISBN is not present, now record is added to DB
    public void addNewBook(Book book) {
        Optional<Book> bookOptional = mySQLRepository.findBookByBookISBN(book.getBookISBN());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("ISBN is in use");
        }
        mySQLRepository.save(book);
    }
}
