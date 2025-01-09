package com.example.Book_And_Autor_Manager.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Author;
import com.example.Book_And_Autor_Manager.Service.IAuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    // create author
    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody Author author) {
        try {
            authorService.createAuthor(author);
            return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while creating player: " + e.getMessage());
        }
    }

    // get all authors
    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
        try {
            List<AuthorInfoDto> authors = authorService.getAllAuthors();

            if (authors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("no authors founded");
            }
            return ResponseEntity.ok(authors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching the friends: " + e.getMessage());
        }
    }

    // get all books of author
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllBooksOfAuthors(@PathVariable Long id) {
        try {
            List<BooksAuthorDto> authors = authorService.getBooksOfAuthor(id);

            if (authors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("The author has no books");
            }
            return ResponseEntity.ok(authors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching the friends: " + e.getMessage());
        }
    }

}
