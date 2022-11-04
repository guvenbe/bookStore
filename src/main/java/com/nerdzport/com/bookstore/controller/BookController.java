package com.nerdzport.com.bookstore.controller;

import com.nerdzport.com.bookstore.dto.BookDto;
import com.nerdzport.com.bookstore.service.BookService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@OpenAPI30()
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    //    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Books API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retried list of book"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found resource")
    })
    @GetMapping()
    public ResponseEntity<List<BookDto>> getBooks() {
//        BookDto book1 = BookDto.builder()
//                .title("test title")
//                .build();
//        List<BookDto> books= new ArrayList<>();
//        BookDto book2 = BookDto.builder()
//                .title("My First Book Title2")
//                .description("test description")
//                .releaseYear(2020)
//                .build();
//        books.add(book1);

        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

}