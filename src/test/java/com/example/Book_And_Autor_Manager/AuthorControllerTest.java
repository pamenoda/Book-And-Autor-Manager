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

import com.example.Book_And_Autor_Manager.Controller.AuthorController;
import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.Entity.Author;
import com.example.Book_And_Autor_Manager.Service.IAuthorService;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @Mock
    private IAuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAuthor_ShouldReturnCreatedMessage_WhenSuccessful() {
        // set up the expected value
        Author author = new Author();
        when(authorService.createAuthor(author)).thenReturn(author);

        // execute to get the response
        ResponseEntity<?> response = authorController.createPlayer(author);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Created successfully", response.getBody());
    }

    @Test
    void getAuthor_ShouldReturnAuthor_WhenPlayerExists() {
        // set up the expected value
        List<AuthorInfoDto> authors = List.of(new AuthorInfoDto("Friend1", "zdazd"),
                new AuthorInfoDto("Friend2", "azda"));

        when(authorService.getAllAuthors()).thenReturn(authors);

        // execute to get the response
        ResponseEntity<?> response = authorController.getAllAuthors();

        // check value with expected value
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(authors, response.getBody());
        verify(authorService, times(1)).getAllAuthors();
    }
}
