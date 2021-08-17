package com.sda.booksstore.repository;

import com.sda.booksstore.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Profile("default")
@Repository
public class HashMapBookRepository implements BookRepository {

    public static final Map<Long, Book> MAP_DB = new HashMap<>();

    private static Long LAST_ID = 0L;

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(MAP_DB.get(id));
    }

    @Override
    public Optional<Book> findByISBN(Integer bookISBN) {
        return MAP_DB.values().stream()
                .filter(u -> u.getBookISBN().equals(bookISBN))
                .findFirst();
    }

    @Override
    public Optional<Book> findByAuthor(String bookAuthor) {
        return MAP_DB.values().stream()
                .filter(u -> u.getBookAuthor().equals(bookAuthor))
                .findFirst();
    }

    @Override
    public Collection<Book> findAll() {
        return MAP_DB.values();
    }

    @Override
    public Book save(Book book) {
        Long newId = LAST_ID + 1;
        book.setId(newId);
        MAP_DB.put(newId, book);
        LAST_ID = newId;
        return book;
    }

    @Override
    public Book update(Book book, Long id) {
        var existingBook = findById(id)
                .orElseThrow(() -> new RuntimeException(String
                        .format("Book with this id %s is not existing", id)));

        existingBook
                .setBookName(book.getBookName())
                .setBookAuthor(book.getBookAuthor())
                .setBookISBN(book.getBookISBN())
                .setBookDescription(book.getBookDescription())
                .setBookPages(book.getBookPages());

        return existingBook;

    }

    @Override
    public void delete(Long id) {
        MAP_DB.remove(id);
    }

    @Override
    public void delete(Integer bookISBN) {
        MAP_DB.remove(bookISBN);
    }
}
