package com.lotaproject.lms.repository;

import com.lotaproject.lms.models.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {
    boolean existsByName(String name);
}
