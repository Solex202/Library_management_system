package com.lotaproject.lms.services;

import com.lotaproject.lms.exceptions.ExceptionMessages;
import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.repository.BookRepository;
import com.lotaproject.lms.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.lotaproject.lms.exceptions.ExceptionMessages.*;

@Service
public class FolderServiceImpl implements FolderService{

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException(String.format(BOOK_NOT_FOUND, bookId)));
    }

    private Folder findFolderById(Long folderId){
        return folderRepository.findById(folderId).orElseThrow(()-> new LmsException(FOLDER_NOT_FOUND));
    }
    @Override
    public Folder createFolder(String name) {
        if(folderRepository.existsByName(name)) throw new LmsException(FOLDER_ALREADY_EXISTS);

        Folder folder = Folder.builder().name(name).createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now()).build();
        return folderRepository.save(folder);
    }

    @Override
    public void addBookToFolder(Long folderId, List<Long> bookIds) {
        Folder folder =  findFolderById(folderId);
        List<Book> bookList = new ArrayList<>();

        bookIds.forEach(bookId -> {
            Book book = findBookById(bookId);
            bookList.add(book);
        });
        folder.setBookList(bookList);
        folderRepository.save(folder);
    }
}
