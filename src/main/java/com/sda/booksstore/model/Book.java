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
@Table(name = "books", schema = "bookstore")
public class Book {

    @Id
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    @NotBlank(message = "Name is required")
    private String bookName;

    @Column(name = "book_author")
    @NotBlank(message = "Author is required")
    private String bookAuthor;

    @Column(name = "book_isbn")
    @NotNull(message = "Book ISBN number is required")
    private Integer bookISBN;

    @Column(name = "book_description")
    @NotBlank(message = "Book description is required")
    private String bookDescription;

    @Column(name = "book_pages")
    @NotBlank(message = "Pages quantity is required")
    private String bookPages;

}
