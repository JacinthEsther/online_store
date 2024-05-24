package com.jacinth.online_bookstore.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

}
