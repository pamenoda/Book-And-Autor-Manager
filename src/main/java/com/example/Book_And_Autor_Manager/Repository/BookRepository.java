package com.example.Book_And_Autor_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book_And_Autor_Manager.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
