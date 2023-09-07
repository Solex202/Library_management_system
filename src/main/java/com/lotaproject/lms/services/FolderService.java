package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Folder;

import java.util.List;

public interface FolderService {

    Folder createFolder(String name);

    void addBookToFolder(Long folderId, List<Long> bookId);
}
