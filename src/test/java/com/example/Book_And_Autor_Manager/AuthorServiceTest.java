package com.example.Book_And_Autor_Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Book_And_Autor_Manager.DAO.IAuthorDAO;
import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.Entity.Author;
import com.example.Book_And_Autor_Manager.Service.IAuthorService;

public class AuthorServiceTest {
    @Mock
    private IAuthorDAO authorDAO;

    @InjectMocks
    private IAuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAuthor_ShouldReturnCreatedAuthor() {
        // set up the expected value
        Author author = new Author(1L, "test", "tesa");

        // execute to get the response
        when(authorDAO.save(author)).thenReturn(author);

        Author createdAuthor = authorService.createAuthor(author);
        // check value with expected value
        assertNotNull(createdAuthor);
        assertEquals("tesa", author.getFirstName());
        verify(authorDAO, times(1)).save(author);
    }

    @Test
    void getAllAuthors_ShouldReturnFriendList() {
        List<AuthorInfoDto> authors = new ArrayList<>();
        authors.add(new AuthorInfoDto("friend1", "f1"));
        authors.add(new AuthorInfoDto("friend2", "f2"));

        // execute to get the response
        when(authorDAO.findAllAuthors()).thenReturn(authors);

        List<AuthorInfoDto> result = authorService.getAllAuthors();
        // check value with expected value
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(authorDAO, times(1)).findAllAuthors();
    }

}
