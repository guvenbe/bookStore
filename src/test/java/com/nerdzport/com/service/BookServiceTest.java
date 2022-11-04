package com.nerdzport.com.service;

import com.nerdzport.com.bookstore.dto.BookDto;
import com.nerdzport.com.bookstore.model.Book;
import com.nerdzport.com.bookstore.repository.BookRepository;
import com.nerdzport.com.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldReturnListOfBookDtoWhenGetBooksIsCalled() {
        List<Book> books = new ArrayList<>();
        Book book = getBook();
        books.add(book);
        BookDto bookDto = getBookDto();
        when(bookRepository.findAll()).thenReturn(books);
        when(modelMapper.map(books, BookDto.class)).thenReturn(bookDto);
        List<BookDto> bookDtos = bookService.getBooks();
        assertThat(1).isEqualTo(bookDtos.size());
        assertThat(bookDtos.get(0))
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "Test Title")
                .hasFieldOrPropertyWithValue("description", "Test Description")
                .hasFieldOrPropertyWithValue("releaseYear", 2020);
    }

    private Book getBook() {
        return Book.builder()
                .id(UUID.randomUUID())
                .title("Test Title")
                .description("Test Description")
                .releaseYear(2020)
                .build();
    }

    private BookDto getBookDto() {
        return BookDto.builder()
                .id(UUID.randomUUID())
                .title("Test Title")
                .description("Test Description")
                .releaseYear(2020)
                .build();
    }
}