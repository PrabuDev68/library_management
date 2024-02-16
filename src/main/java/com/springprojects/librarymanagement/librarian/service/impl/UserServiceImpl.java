package com.springprojects.librarymanagement.librarian.service.impl;

import com.springprojects.librarymanagement.librarian.model.Book;
import com.springprojects.librarymanagement.librarian.model.User;
import com.springprojects.librarymanagement.librarian.repository.BookRepository;
import com.springprojects.librarymanagement.librarian.repository.UserRepository;
import com.springprojects.librarymanagement.librarian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean borrowBook(String id,String isbn) {
        User user = userRepository.findById(id).orElse(null);
        Book b = bookRepository.findById(isbn).orElse(null);
        if(b!=null && b.getAvailability() && user != null){
            b.setAvailableBooks(b.getAvailableBooks()-1);
            b.setAvailability(b.getAvailableBooks());
            user.getBorrowedBooks().add(b);
            b.getBorrowers().add(user);
            userRepository.save(user);
            bookRepository.save(b);
            return true;
        }
        return false;
    }

    @Override
    public Boolean returnBook(String id,String isbn) {
        User user = userRepository.findById(id).orElse(null);
        Book b = bookRepository.findById(isbn).orElse(null);
        if(b!=null && user != null ){
            b.setAvailableBooks(b.getAvailableBooks()+1);
            b.setAvailability(b.getAvailableBooks());
            user.getBorrowedBooks().remove(b);
            b.getBorrowers().remove(user);
            userRepository.save(user);
            bookRepository.save(b);
            return true;
        }
        return false;
    }
}
