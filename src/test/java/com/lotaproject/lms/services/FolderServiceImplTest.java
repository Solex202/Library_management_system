package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Folder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FolderServiceImplTest {

    @Autowired
    private FolderService folderService;

    @Test
    void createFolder() {
        String name = "documents";
        Folder folder = folderService.createFolder(name);
    }

    @Test
    void addBookToFolder() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        folderService.addBookToFolder(1L ,ids);
    }
}