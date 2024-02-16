package com.springprojects.librarymanagement.librarian.repository;

import com.springprojects.librarymanagement.librarian.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
