package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Library;
import com.lotaproject.lms.models.Shelf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShelfServiceImplTest {

    @Autowired
    private ShelfService shelfService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createShelf() {
        String name = "shelf 1";
        String category = "Science books";

        Shelf shelf = shelfService.createShelf(name, category);

        assertNotNull(shelf);
    }

    @Test
    void addBookToShelf() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        shelfService.addBookToShelf(1L ,ids);
    }

    @Test
    void addFolderToShelf(){
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        shelfService.addFolderToShelf(1L, ids);
    }

    @Test
    void createLibrary(){
        Library library = shelfService.createLibrary("Enum library");
    }

    @Test
    void addShelfToLibrary(){
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        shelfService.addShelfToLibrary(1L, ids);
    }
}