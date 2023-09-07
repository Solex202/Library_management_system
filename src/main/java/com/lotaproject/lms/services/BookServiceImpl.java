package com.lotaproject.lms.services;

import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    @Override
    public Book createBook(Book book) {
        if(bookRepository.existsByIsbn(book.getIsbn())){
            throw new LmsException("Book with isbn already exists");
        }
        if(book.getIsbn().length() != 11){
            throw new LmsException("Invalid ISBN length");
        }

        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException("Book not found"));
    }
}
