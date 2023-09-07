package com.lotaproject.lms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Folder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     @OneToMany(mappedBy = "folder")
     private List<Book> bookList = new ArrayList<>();
     private LocalDateTime createdDate;
     private LocalDateTime modifiedDate;

}
