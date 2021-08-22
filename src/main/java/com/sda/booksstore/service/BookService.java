package com.sda.booksstore.service;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("default")
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book saveBook(Book book) {
        var existingBook = repository.findByISBN(book.getBookISBN());
        if (existingBook.isPresent()) {
            System.out.printf("Book with ISBN %s is existing - cannot save", book.getBookISBN());
            throw new RuntimeException(String.format("Book with ISBN %s is existing - cannot save", book.getBookISBN()));
        }
        return repository.save(book);
    }

    public Book getById(Long id) {
        var bookOptional = repository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        System.out.printf("Book with id %d does not exist", id);
        return null;
    }

    public Book getByISBN(Integer bookISBN) {
        var bookOptional = repository.findByISBN(bookISBN);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        System.out.printf("Book with ISBN %d does not exist", bookISBN);
        return null;
    }

    public Book getByAuthor(String bookAuthor) {
        var bookOptional = repository.findByAuthor(bookAuthor);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        System.out.printf("Book written by author %s does not exist", bookAuthor);
        return null;
    }

    public Collection<Book> getAllBooks() {
        return repository.findAll();
    }

    public void removeBookById(Long id) {
        repository.delete(id);
    }

    public void removeBookByISBN(Integer bookISBN) {
        repository.delete(bookISBN);
    }

    public Book update(Book book, Long id) {
        return repository.update(book, id);
    }

    private boolean filterByMatchingFields(Book book, String name, Integer bookISBN) {
        boolean matchingName = Optional.ofNullable(name)
                .map(n -> book.getBookName().equalsIgnoreCase(n))
                .orElse(true);

        boolean matchingISBN = Optional.ofNullable(bookISBN)
                .map(n -> book.getBookISBN().equals(n))
                .orElse(true);

        return matchingName && matchingISBN;
    }

    public List<Book> getAllAndFilter(String name, Integer isbn) {
        return repository.findAll().stream()
                .filter(s -> filterByMatchingFields(s, name, isbn))
                .collect(Collectors.toList());
    }

}
