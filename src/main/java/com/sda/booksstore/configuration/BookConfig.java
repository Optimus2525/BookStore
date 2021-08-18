package com.sda.booksstore.configuration;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.MySQLRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.List;

@Profile("MySQL")

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(MySQLRepository mySQLRepository) {
        return args -> {

            Book book1 = new Book(
                    "Aizraujošā programmēšana",
                    "Janis Siliņš",
                    258741,
                    "Reāli laba grāmata",
                    "468");

            Book book2 = new Book(
                    "Java Hibernate Cookbook",
                    "Vishal Ranapariya",
                    465821,
                    "Learn to associate JDBC and Hibernate with object persistence.",
                    "468");

            Book book3 = new Book(
                    "Hibernate Search in Action",
                    "Emmanuel Bernard",
                    852143,
                    "Hibernate Search in Action is a practical, example-oriented guide " +
                            "for Java developers with some background in Hibernate Core.",
                    "711");

            mySQLRepository.saveAll(List.of(
                    book1, book2, book3)
            );

        };
    }

}
