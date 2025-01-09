package com.example.Book_And_Autor_Manager.DAO;

import java.util.List;
import java.util.Optional;

import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Book;

public interface IBookDAO {

    Book save(Book book);

    Optional<Book> findById(Long id); // search a book

    List<BooksAuthorDto> getAllBooks();

    void deleteBookById(Long id);
}
