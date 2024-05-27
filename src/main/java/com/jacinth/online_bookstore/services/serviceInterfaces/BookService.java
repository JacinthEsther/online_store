package com.jacinth.online_bookstore.services.serviceInterfaces;


import com.jacinth.online_bookstore.dtos.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    BookDTO addBook(BookDTO bookDTO);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);
}
