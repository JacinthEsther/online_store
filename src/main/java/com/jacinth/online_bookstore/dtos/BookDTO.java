package com.jacinth.online_bookstore.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class BookDTO {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @Min(value = 1000, message = "Publication year must be at least 1000")
    private int publicationYear;
    @NotBlank(message = "ISBN is required")
    private String isbn;
}
