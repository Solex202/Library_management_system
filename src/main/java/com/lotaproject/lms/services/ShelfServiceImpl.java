package com.lotaproject.lms.services;

import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.models.Library;
import com.lotaproject.lms.models.Shelf;
import com.lotaproject.lms.repository.BookRepository;
import com.lotaproject.lms.repository.FolderRepository;
import com.lotaproject.lms.repository.LibraryRepository;
import com.lotaproject.lms.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.lotaproject.lms.exceptions.ExceptionMessages.BOOK_NOT_FOUND;

@Service
public class ShelfServiceImpl implements ShelfService{

    @Autowired
    private ShelfRepository shelfRepository;
    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    public Shelf findShelfById(Long shelfId){
        return shelfRepository.findById(shelfId).orElseThrow(()-> new LmsException("Shelf not found"));
    }

    public Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException(String.format(BOOK_NOT_FOUND, bookId)));
    }

    public Folder findFolderById(Long folderId){
        return folderRepository.findById(folderId).orElseThrow(()-> new LmsException("Folder not found"));
    }
    public Library findLibraryById(Long libraryId){
        return libraryRepository.findById(libraryId).orElseThrow(()-> new LmsException("Library not found"));
    }
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
    public void addFolderToShelf(Long shelfId, List<Long> folderIds) {
        Shelf shelf =  findShelfById(shelfId);

        List<Folder> folderList = new ArrayList<>();

        folderIds.forEach(folderId -> {
            Folder folder = findFolderById(folderId);
            folderList.add(folder);
        });
        shelf.setFolders(folderList);
        shelfRepository.save(shelf);
    }

    @Override
    public Library createLibrary(String name) {
        if(libraryRepository.existsByName(name)) throw new LmsException("Library already exists");
        Library library = Library.builder().name(name)
                .createdDate(LocalDateTime.now()).modifiedDate(LocalDateTime.now()).build();
        return libraryRepository.save(library);
    }

    @Override
    public void addShelfToLibrary(long libraryId, List<Long> shelfIds) {
        Library library =  findLibraryById(libraryId);

        List<Shelf> shelfList = new ArrayList<>();

        shelfIds.forEach(shelfId -> {
            Shelf shelf = findShelfById(shelfId);

            shelfList.add(shelf);
        });
        library.setShelf(shelfList);
        libraryRepository.save(library);
    }
}
