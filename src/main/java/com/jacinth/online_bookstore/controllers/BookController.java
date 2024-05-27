package com.jacinth.online_bookstore.controllers;

import com.jacinth.online_bookstore.dtos.BookDTO;
import com.jacinth.online_bookstore.exceptions.ErrorResponse;
import com.jacinth.online_bookstore.exceptions.ResourceNotFoundException;
import com.jacinth.online_bookstore.services.serviceInterfaces.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(
            value = "/addbooks/{email}",
            produces = "application/json",
            method = RequestMethod.POST)

    @PreAuthorize("@userServiceImpl.isUserAdmin(#email, authentication)")
    public ResponseEntity<BookDTO> addBook(@PathVariable String email,@Valid @RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }



    @PutMapping("/{email}/{book_id}")
    @PreAuthorize("@userServiceImpl.isUserAdmin(#email, authentication)")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@PathVariable String email, @Valid @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/email/{book_id}")
    @PreAuthorize("@userServiceImpl.isUserAdmin(#email, authentication)")
    public ResponseEntity<Void> deleteBook(@PathVariable String email,@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
