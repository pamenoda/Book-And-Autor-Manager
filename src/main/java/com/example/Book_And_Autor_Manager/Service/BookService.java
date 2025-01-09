package com.example.Book_And_Autor_Manager.Service;

import java.util.List;

import com.example.Book_And_Autor_Manager.DAO.IBookDAO;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Book;

public class BookService implements IBookService {

    private final IBookDAO bookDAO;

    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book createBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public void DeleteBook(Long id) {
        Book book = bookDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not found with ID: " + id));

        bookDAO.deleteBookById(id);
    }

    @Override
    public List<BooksAuthorDto> getAllBooks() {

        List<BooksAuthorDto> booksAuthorDtos = bookDAO.getAllBooks();

        if (booksAuthorDtos.isEmpty())
            new IllegalArgumentException("books not found");

        return booksAuthorDtos;
    }

    @Override
    public BooksAuthorDto getBookById(Long id) {
        Book book = bookDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("book not found with ID: " + id));

        return new BooksAuthorDto(book.getTitle(), book.getGender());
    }

    @Override
    public void updateBook(Long id, BooksAuthorDto booksAuthorDto) {
        Book existingBook = bookDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with ID: " + id));

        if (booksAuthorDto.getTitle() != null)
            existingBook.setTitle(booksAuthorDto.getTitle());
        if (booksAuthorDto.getGender() != null)
            existingBook.setGender(booksAuthorDto.getGender());

        bookDAO.save(existingBook);
    }

}
