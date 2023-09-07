package com.lotaproject.lms.services;

import com.lotaproject.lms.exceptions.LmsException;
import com.lotaproject.lms.models.Book;
import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.repository.BookRepository;
import com.lotaproject.lms.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService{

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private BookRepository bookRepository;

    private Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new LmsException("Book not found"));
    }
    @Override
    public Folder createFolder(String name) {
        if(folderRepository.existsByName(name)) throw new LmsException("Folder already exists");
        Folder folder = new Folder();
        folder.setName(name);
        return folderRepository.save(folder);
    }

    @Override
    public void addBookToFolder(Long folderId,Long bookId) {
        Book book = findBookById(bookId);

    }
}
