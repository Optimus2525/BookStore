CREATE TABLE books (
    bookId INT NOT NULL AUTO_INCREMENT
    , bookName VARCHAR(255)
    , bookAuthor VARCHAR(100)
    , bookISBN VARCHAR(30)
    , bookDescription VARCHAR(255)
    , bookpages INT
    , PRIMARY KEY (bookId)
);


insert into books (bookName
	, bookAuthor
	, bookISBN
	, bookDescription
	, bookPages) values('Learning Spring Boot 2.0', 'Craig Walls', '862314', 'The book further explores advanced concepts — like the Spring Boot Actuator — to find out what’s going on inside a Spring Boot application.', 253)
		, ('Java Complete reference Eleventh Edition', 'Herbert Schildt', '258963', 'The book about Java', 1453)
		, ('Cloud-Native Java', 'Craig Walls', '321456', 'In the beginning, cloud terminologies, and services may seem overwhelming, but if you stick around and finish the book.', 253)
		, ('Spring Microservices in Action', 'Greg Turnquist', '789654', 'This is another great book on cloud-based Java development, but it focuses on microservices.', 447)
		, ('Mastering Spring Boot 2.0', 'Dinesh Rajput', '357951', 'Once you are familiar with the basics, you will explore advanced things like customizing auto-configuration to meet your expectation.', 753)
    ;


UPDATE books
SET bookDescription = 'The book about Spring framework'
WHERE bookId = 1;


select * from books;