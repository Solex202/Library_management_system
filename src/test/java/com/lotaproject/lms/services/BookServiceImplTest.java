package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
        book.setIsbn("12345678901");

        Book newBook = bookService.createBook(book);
        assertAll(
                ()->  assertNotNull(newBook),
                ()-> assertThat(book.getName(), is(newBook.getName()))
        );
    }

    @Test
    void findBookByAdd(){
        Book book = bookService.findBookById(1L);
    }
    @AfterEach
    void tearDown() {
    }
}