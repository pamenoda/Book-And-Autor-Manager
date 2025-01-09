package com.example.Book_And_Autor_Manager.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Author;
import com.example.Book_And_Autor_Manager.Repository.AuthorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AuthorDAO implements IAuthorDAO {
    private final AuthorRepository authorRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    public AuthorDAO(AuthorRepository authorRepository, EntityManager entityManager) {
        this.authorRepository = authorRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorInfoDto> findAllAuthors() {
        String query = "SELECT new com.example.Book_And_Author_Manager.DTO.AuthorInforDto(a.firstName, a.lastName)" +
                "FROM Author a";
        return entityManager.createQuery(query, AuthorInfoDto.class).getResultList();
    }

    @Override
    public List<BooksAuthorDto> findallBooksOfAuthor(Long authorId) {
        String query = "SELECT new  com.example.Book_And_Author_Manager.DTO.BooksAuthorDto(b.title,b.gender) " +
                "FROM Author a JOIN Book b ON b.author_Id = a.id " +
                "WHERE a.id = :authorId";

        return entityManager.createQuery(query, BooksAuthorDto.class).setParameter("id", authorId).getResultList();
    }

}
