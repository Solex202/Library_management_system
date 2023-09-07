package com.lotaproject.lms.services;

import com.lotaproject.lms.dto.response.PaginatedBookResponse;
import com.lotaproject.lms.models.Book;

public interface BookService {
    Book createBook(Book book);

    Book findBookById(Long bookId);

    PaginatedBookResponse findAllBooks(int pageNumber, int pageSize);
}
