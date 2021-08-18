package com.sda.booksstore.service;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.MySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Long countBooks() {
        return mySQLRepository.count();
    }

}
