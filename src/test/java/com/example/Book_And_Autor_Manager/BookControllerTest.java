package com.example.Book_And_Autor_Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.Book_And_Autor_Manager.Controller.BookController;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Book;
import com.example.Book_And_Autor_Manager.Service.IBookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Mock
    private IBookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBook_ShouldReturnCreatedBook() {
        // set up the expected value
        Book book = new Book(1L, "adad", "adazd", 2L);

        // execute to get the response
        when(bookService.createBook(book)).thenReturn(book);

        // execute to get the response
        ResponseEntity<?> response = bookController.createBook(book);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Created successfully", response.getBody());
    }

    @Test
    void deleteBook_ShouldReturnSuccess_WhenBookDeleted() {
        // set up the expected value
        Long bookId = 1L;

        // execute to get the response
        ResponseEntity<?> response = bookController.deleteBook(bookId);

        // check value with expected value
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Player deleted successfully.", response.getBody());
        verify(bookService, times(1)).DeleteBook(bookId);
        ;
    }

    void getBooks_ShouldReturnBooksDto_WhenPlayerExists() {
        // set up the expected value
        List<BooksAuthorDto> books = List.of(new BooksAuthorDto("Friend1", "zdazd"),
                new BooksAuthorDto("Friend2", "azda"));

        // execute to get the response
        when(bookService.getAllBooks()).thenReturn(books);

        ResponseEntity<?> response = bookController.getAllBooks();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(books, response.getBody());
        verify(bookService, times(1)).getAllBooks();
    }

}
