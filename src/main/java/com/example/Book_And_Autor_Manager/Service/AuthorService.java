package com.example.Book_And_Autor_Manager.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Book_And_Autor_Manager.DAO.IAuthorDAO;
import com.example.Book_And_Autor_Manager.DTO.AuthorInfoDto;
import com.example.Book_And_Autor_Manager.DTO.BooksAuthorDto;
import com.example.Book_And_Autor_Manager.Entity.Author;

@Service
public class AuthorService implements IAuthorService {

    private final IAuthorDAO authorDAO;

    public AuthorService(IAuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorDAO.save(author);
    }

    @Override
    public List<AuthorInfoDto> getAllAuthors() {
        return authorDAO.findAllAuthors();
    }

    @Override
    public List<BooksAuthorDto> getBooksOfAuthor(long authorId) {
        return authorDAO.findallBooksOfAuthor(authorId);
    }

}