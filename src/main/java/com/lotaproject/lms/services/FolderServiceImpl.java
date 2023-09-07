package com.lotaproject.lms.services;

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

@Service
public class FolderServiceImpl implements FolderService{

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException("Book not found"));
    }

    private Folder findFolderById(Long folderId){
        return folderRepository.findById(folderId).orElseThrow(()-> new LmsException("folder not found"));
    }
    @Override
    public Folder createFolder(String name) {
        if(folderRepository.existsByName(name)) throw new LmsException("Folder already exists");
        Folder folder = new Folder();
        folder.setName(name);
        folder.setCreatedDate(LocalDateTime.now());
        folder.setModifiedDate(LocalDateTime.now());
        return folderRepository.save(folder);
    }

    @Override
    public void addBookToFolder(Long folderId, List<Long> bookIds) {
        Folder folder =  findFolderById(folderId);
        List<Book> bookList = new ArrayList<>();
//                .stream().forEach(b -> bookIds.);

        for (Long bookId: bookIds) {
            Book book = findBookById(bookId);
            bookList.add(book);
        }

        folder.setBookList(bookList);
        folderRepository.save(folder);

    }
}
