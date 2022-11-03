package com.nerdzport.com.bookstore.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:db/InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchAllBooksFromRepository() {
        var books = bookRepository.findAll();
        long totalBookCount = StreamSupport.stream(books.spliterator(), false).count();
        assertEquals(19, totalBookCount);
    }

    @Test
    @Sql(scripts = {"classpath:db/InsertInitialBookRecordForTest.sql"})
    void shouldReturnOneBookWhenTitleIsTestTitle() {
        var books = bookRepository.findBooksByTitle("Test Title");
         assertEquals(1, books.size(), "Should return one book");


    }


}