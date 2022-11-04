package com.nerdzport.com.bookstore.IntegrationTest;

import com.nerdzport.com.bookstore.BookStoreApplication;
import com.nerdzport.com.bookstore.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = BookStoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    @Sql(scripts = {"/db/insertInitialBookRecordForTest.sql"})
    void shouldReturnBooksWhenBooksApiIsCalled() {
        BookDto[] listOfBooks = testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/books", BookDto[].class);
        //when
        //then
        assertThat(listOfBooks);
        assertThat(listOfBooks.length).isEqualTo(19);
    }

    @Test
    @Sql(scripts = {"/db/insertInitialBookRecordForTest.sql"})
    void shouldReturnBooksWhenBooksApiIsCalled1() {
        BookDto[] listOfBooks = testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/books", BookDto[].class);
        //when
        //then
        assertThat(listOfBooks);
        assertThat(listOfBooks.length).isEqualTo(19);
    }
}
