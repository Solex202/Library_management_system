package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Folder;
import com.lotaproject.lms.models.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf createShelf(String name, String category);

    void addBookToShelf(Long folderId, List<Long> bookId);


}
