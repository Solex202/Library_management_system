package com.lotaproject.lms.dto.response;

import com.lotaproject.lms.models.Book;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PaginatedBookResponse {

    private List<Book> bookList;

    private int currentPage;

    private int noOfBooks;

    private int pageSize;
}
