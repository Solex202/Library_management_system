package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.models.Library;
import com.lotaproject.lms.models.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf createShelf(String name, String category);

    void addBookToShelf(Long shelfId, List<Long> bookId);


    void addFolderToShelf(Long shelfId, List<Long >folderId);

    Library createLibrary(String name);

    void addShelfToLibrary(long libraryId, List<Long> ids);
}
