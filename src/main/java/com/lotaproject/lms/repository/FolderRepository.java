package com.lotaproject.lms.repository;

import com.lotaproject.lms.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    boolean existsByName(String name);
}
