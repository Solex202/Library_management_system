package com.lotaproject.lms.services;

import com.lotaproject.lms.dto.response.PaginatedBookResponse;
import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
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
        book.setAddedDate(LocalDateTime.now());
        book.setModifiedDate(LocalDateTime.now());

        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException("Book not found"));
    }

    @Override
    public PaginatedBookResponse findAllBooks(int pageNumber, int pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "addedDate");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(order));

        Page<Book> bookList = bookRepository.findAll(pageable);
        log.info("BOOK LIST {}", bookList);
        return PaginatedBookResponse.builder()
                .bookList(bookList.toList()).noOfBooks(bookList.getContent().size())
                .currentPage(pageNumber).pageSize(pageSize).build();
    }
}
