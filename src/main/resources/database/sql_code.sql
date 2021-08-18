CREATE TABLE books (
    book_id INT NOT NULL AUTO_INCREMENT
    , book_name VARCHAR(255)
    , book_author VARCHAR(100)
    , book_isbn VARCHAR(30)
    , book_description VARCHAR(255)
    , book_pages INT
    , PRIMARY KEY (book_id)
);


insert into books ( book_name
                  , book_author
                  , book_isbn
                  , book_description
                  , book_pages)
values ('Learning Spring Boot 2.0', 'Craig Walls', '862314',
        'The book further explores advanced concepts — like the Spring Boot Actuator — to find out what’s going
        on inside a Spring Boot application.',
        253)
     , ('Java Complete reference Eleventh Edition', 'Herbert Schildt', '258963', 'The book about Java', 1453)
     , ('Cloud-Native Java', 'Craig Walls', '321456',
        'In the beginning, cloud terminologies, and services may seem overwhelming, but if you stick around and
        finish the book.',
        253)
     , ('Spring Microservices in Action', 'Greg Turnquist', '789654',
        'This is another great book on cloud-based Java development, but it focuses on microservices.', 447)
     , ('Mastering Spring Boot 2.0', 'Dinesh Rajput', '357951',
        'Once you are familiar with the basics, you will explore advanced things like customizing auto-configuration
        to meet your expectation.',
        753)
;

select *
from books;

insert into books ( book_name
                  , book_author
                  , book_isbn
                  , book_description
                  , book_pages)
values ('The iron Heel', 'Jack London', '789654',
        'The novel is told via the framing device of a manuscript found centuries after the action takes place and
        footnotes by a scholar, Anthony Meredith, circa 2600 AD or 419 B.O.M. (the Brotherhood of Man)',
        458)