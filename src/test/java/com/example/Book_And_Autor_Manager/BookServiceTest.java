package com.example.Book_And_Autor_Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Book_And_Autor_Manager.DAO.IBookDAO;
import com.example.Book_And_Autor_Manager.Entity.Book;
import com.example.Book_And_Autor_Manager.Service.IBookService;

public class BookServiceTest {

    @Mock
    private IBookDAO bookDAO;

    @InjectMocks
    private IBookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPlayer_ShouldReturnCreatedPlayer() {
        // set up the expected value
        Book book = new Book(1L, "test", "adad", 1L);

        // execute to get the response
        when(bookDAO.save(book)).thenReturn(book);

        Book createdPlayer = bookService.createBook(book);
        // check value with expected value
        assertNotNull(createdPlayer);
        assertEquals("test", createdPlayer.getTitle());
        verify(bookDAO, times(1)).save(book);
    }

    @Test
    void findById_ShouldReturnPlayer_WhenPlayerExists() {
        // set up the expected value
        Long bookId = 1L;
        Book book = new Book(1L, "adaz", "adad", 1L);

        // execute to get the response
        when(bookDAO.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookDAO.findById(bookId);

        assertNotNull(foundBook);
        verify(bookDAO, times(1)).findById(bookId);
    }

    @Test
    void deleteBook_ShouldDeletePlayer_WhenExists() {
        // set up the expected value
        Long bookId = 1L;

        // execute to get the response
        when(bookDAO.findById(bookId));

        bookService.DeleteBook(bookId);

        // check value with expected value
        verify(bookDAO, times(1)).findById(bookId);
    }

}
