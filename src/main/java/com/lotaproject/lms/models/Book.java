package com.lotaproject.lms.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;

    private String isbn;
    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;
    private LocalDateTime addedDate;
    private LocalDateTime modifiedDate;
}
