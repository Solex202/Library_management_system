package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Shelf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService{

    @Override
    public Shelf createShelf(String name, String category) {
        return null;
    }

    @Override
    public void addBookToShelf(Long folderId, List<Long> bookId) {

    }
}
