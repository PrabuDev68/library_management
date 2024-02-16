package com.springprojects.librarymanagement.librarian.repository;

import com.springprojects.librarymanagement.librarian.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,String> {
}
