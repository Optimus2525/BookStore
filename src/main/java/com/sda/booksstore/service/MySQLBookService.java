package com.sda.booksstore.service;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.MySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // This is adding books into database
    @Bean
    CommandLineRunner commandLineRunner(MySQLRepository mySQLRepository) {
        return args -> {

            Book book1 = new Book(

                    "Aizraujošā programmēšana",
                    "Janis Siliņš",
                    555555,
                    "Reāli laba grāmata",
                    "468");

            Book book2 = new Book(

                    "Java Hibernate Cookbook",
                    "Vishal Ranapariya",
                    666666,
                    "Learn to associate JDBC and Hibernate with object persistence.",
                    "468");

            Book book3 = new Book(

                    "Hibernate Search in Action",
                    "Emmanuel Bernard",
                    777777,
                    "Hibernate Search in Action is a practical, example-oriented guide " +
                            "for Java developers with some background in Hibernate Core.",
                    "711");

            mySQLRepository.saveAll(List.of(book1, book2, book3));
        };
    }



}
