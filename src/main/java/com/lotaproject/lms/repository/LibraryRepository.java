package com.lotaproject.lms.repository;

import com.lotaproject.lms.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository <Library, Long>{
    public boolean existsByName(String name) ;
}
