package com.jacinth.online_bookstore.repositories;

import com.jacinth.online_bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
