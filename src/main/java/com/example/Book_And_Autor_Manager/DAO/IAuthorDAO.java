package com.example.Book_And_Autor_Manager.DAO;

import java.util.List;

import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Author;

public interface IAuthorDAO {
    Author save(Author author); // save a player

    List<AuthorInfoDto> findAllAuthors();

    List<BooksAuthorDto> findallBooksOfAuthor(Long authorId);
}
