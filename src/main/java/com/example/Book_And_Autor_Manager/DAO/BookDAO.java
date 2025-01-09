package com.example.Book_And_Autor_Manager.DAO;

import java.util.List;
import java.util.Optional;

import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Book;
import com.example.Book_And_Autor_Manager.Repository.BookRepository;

import jakarta.persistence.EntityManager;

public class BookDAO implements IBookDAO {

    private final BookRepository bookRepository;

    private final EntityManager entityManager;

    public BookDAO(BookRepository bookRepository, EntityManager entityManager) {
        this.bookRepository = bookRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BooksAuthorDto> getAllBooks() {
        String query = "SELECT new  com.example.Book_And_Author_Manager.DTO.BooksAuthorDto(b.title,b.gender) " +
                "FROM Book ";
        return entityManager.createQuery(query, BooksAuthorDto.class).getResultList();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
