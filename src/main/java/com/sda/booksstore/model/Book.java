package com.sda.booksstore.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "bookId")
    private Long id;

    @Column(name = "bookName")
    @NotBlank(message = "Name is required")
    private String bookName;

    @Column(name = "bookAuthor")
    @NotBlank(message = "Author is required")
    private String bookAuthor;

    @Column(name = "bookISBN")
    @NotNull(message = "Book ISBN number is required")
    private Integer bookISBN;

    @Column(name = "bookDescription")
    @NotBlank(message = "Book description is required")
    private String bookDescription;

    @Column(name = "bookPages")
    @NotBlank(message = "Pages quantity is required")
    private String bookPages;

    public Book(String bookName,
                String bookAuthor,
                Integer bookISBN,
                String bookDescription,
                String bookPages) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookISBN = bookISBN;
        this.bookDescription = bookDescription;
        this.bookPages = bookPages;
    }
}
