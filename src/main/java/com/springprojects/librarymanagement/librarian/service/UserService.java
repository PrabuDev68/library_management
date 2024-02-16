package com.springprojects.librarymanagement.librarian.service;


import com.springprojects.librarymanagement.librarian.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    public Boolean borrowBook(String id,String Isbn);
    public Boolean returnBook(String id,String Isbn);
}
