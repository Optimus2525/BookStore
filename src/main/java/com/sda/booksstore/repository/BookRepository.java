package com.sda.booksstore.repository;

import com.sda.booksstore.model.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Long id);

    Optional<Book> findByISBN(Integer bookISBN);

    Optional<Book> findByAuthor(String bookAuthor);

    Collection<Book> findAll();

    Book save(Book book);

    Book update(Book book, Long id);

    void delete(Long id);

    void delete(Integer bookISBN);

}
