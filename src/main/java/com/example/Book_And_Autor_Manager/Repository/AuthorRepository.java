package com.example.Book_And_Autor_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book_And_Autor_Manager.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
