package com.example.Book_And_Autor_Manager.Service;

import java.util.List;

import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Author;

public interface IAuthorService {

    Author createAuthor(Author author);

    List<AuthorInfoDto> getAllAuthors();

    List<BooksAuthorDto> getBooksOfAuthor(long authorId);

}
