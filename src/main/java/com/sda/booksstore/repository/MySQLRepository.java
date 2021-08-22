package com.sda.booksstore.repository;

import com.sda.booksstore.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("MySQL")

@Repository
public interface MySQLRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.bookISBN = ?1")
    Optional<Book> findBookByBookISBN(Integer bookISBN);
}
