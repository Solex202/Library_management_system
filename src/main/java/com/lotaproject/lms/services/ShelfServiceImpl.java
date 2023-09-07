package com.lotaproject.lms.services;

import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.models.Shelf;
import com.lotaproject.lms.repository.BookRepository;
import com.lotaproject.lms.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.lotaproject.lms.exceptions.ExceptionMessages.BOOK_NOT_FOUND;

@Service
public class ShelfServiceImpl implements ShelfService{

    private Shelf findShelfById(Long shelfId){
        return shelfRepository.findById(shelfId).orElseThrow(()-> new LmsException("Shelf not found"));
    }

    private Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException(String.format(BOOK_NOT_FOUND, bookId)));
    }
    @Autowired
    private ShelfRepository shelfRepository;

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Shelf createShelf(String name, String category) {
        if(shelfRepository.existsByName(name)) throw new LmsException("Shelf already exists");

        Shelf shelf = Shelf.builder().name(name).category(category).createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now()).build();
        return shelfRepository.save(shelf);

    }

    @Override
    public void addBookToShelf(Long shelfId, List<Long> bookIds) {
        Shelf shelf =  findShelfById(shelfId);
        List<Book> bookList = new ArrayList<>();

        bookIds.forEach(bookId -> {
            Book book = findBookById(bookId);
            bookList.add(book);
        });
        shelf.setBooks(bookList);
        shelfRepository.save(shelf);
    }

    @Override
    public void addFolderToShelf(long shelfId, long folderId) {
        Shelf shelf =  findShelfById(shelfId);

    }
}
