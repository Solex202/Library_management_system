package com.lotaproject.lms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Folder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private List<Book> bookList = new ArrayList<>();

}
