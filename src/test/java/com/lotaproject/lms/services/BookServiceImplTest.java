package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createBook(){
        Book book = new Book();
        book.setAuthor("author");
        book.setName("The book");
        book.setIsbn("144221321");

        Book newBook = bookService.createBook(book);
    }
    @AfterEach
    void tearDown() {
    }
}