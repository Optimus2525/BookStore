package com.sda.booksstore.service;

import com.sda.booksstore.model.Book;
import com.sda.booksstore.repository.MySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
            throw new IllegalStateException("There is already registered a book in DB with this ISBN code");
        }
        mySQLRepository.save(book);
    }

    // This is deleting book by ID
    public void removeBookById(Long id) {
        boolean exists = mySQLRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "There is not a book with ID: " + id + " in DB");
        }
        mySQLRepository.deleteById(id);
    }

    // This is updating bookName and/or bookDescription
    @Transactional
    public void updateBookById(
            Long id,
            String bookName,
            String bookDescription) {
        Book book = mySQLRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Book with ID: " + id + " does not exist in DB"
                ));

        if (bookName != null
                && bookName.length() > 0
                && !Objects.equals(book.getBookName(), bookName)) {
            book.setBookName(bookName);
        }

        if (bookDescription != null
                && bookDescription.length() > 0
                && !Objects.deepEquals(book.getBookDescription(), bookDescription)) {
             book.setBookDescription(bookDescription);
        }




    }
}
