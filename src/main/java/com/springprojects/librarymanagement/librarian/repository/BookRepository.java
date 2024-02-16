package com.springprojects.librarymanagement.librarian.repository;

import com.springprojects.librarymanagement.librarian.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String>{

    List<Book> findAllByGenreType(String genreType);
    Book findByTitle(String title);
    List<Book> findAllByAuthorId(String authorId);
}
