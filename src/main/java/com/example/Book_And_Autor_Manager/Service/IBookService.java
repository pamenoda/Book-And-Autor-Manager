package com.example.Book_And_Autor_Manager.Service;

import java.util.List;

import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Book;

public interface IBookService {

    Book createBook(Book book);

    void DeleteBook(Long id);

    List<BooksAuthorDto> getAllBooks();

    BooksAuthorDto getBookById(Long id);

    void updateBook(Long id, BooksAuthorDto booksAuthorDto);

}
