package com.lotaproject.lms.services;

import com.lotaproject.lms.models.Folder;

public interface FolderService {

    Folder createFolder(String name);

    void addBookToFolder(Long folderId,Long bookId);
}
