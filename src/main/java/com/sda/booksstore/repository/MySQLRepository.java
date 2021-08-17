package com.sda.booksstore.repository;

import com.sda.booksstore.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("MySQL")

@Repository
public interface MySQLRepository
        extends JpaRepository<Book, Long> {
}
