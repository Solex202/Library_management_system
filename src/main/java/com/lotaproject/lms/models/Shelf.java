package com.lotaproject.lms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    private String category;
    @ManyToOne()
    @JoinColumn(name = "library_id")
    private Library library;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
