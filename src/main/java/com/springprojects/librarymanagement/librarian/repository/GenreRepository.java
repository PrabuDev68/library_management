package com.springprojects.librarymanagement.librarian.repository;

import com.springprojects.librarymanagement.librarian.model.Genre;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,String> {
}
