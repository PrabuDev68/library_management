package com.springprojects.librarymanagement.librarian.service.impl;

import com.springprojects.librarymanagement.librarian.model.Author;
import com.springprojects.librarymanagement.librarian.model.Book;
import com.springprojects.librarymanagement.librarian.model.Genre;
import com.springprojects.librarymanagement.librarian.model.User;
import com.springprojects.librarymanagement.librarian.repository.AuthorRepository;
import com.springprojects.librarymanagement.librarian.repository.BookRepository;
import com.springprojects.librarymanagement.librarian.repository.GenreRepository;
import com.springprojects.librarymanagement.librarian.repository.UserRepository;
import com.springprojects.librarymanagement.librarian.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianServiceImpl implements LibrarianService {


    //BOOK MANAGEMENT
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public void addBook(Book book) {

        bookRepository.save(book);
    }
    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
    @Override
    public void deleteBookByIsbn(String isbn) {
        bookRepository.deleteById(isbn);
    }


    //BOOK DETAILS RETRIEVAL
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    @Override
    public List<Book> getBooksByGenreType(String genreType) {
        return bookRepository.findAllByGenreType(genreType);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthorId(String authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }


    //USER MANAGEMENT
    @Override
    public void addUser(String name,String contact) {
        User user = new User();
        user.setName(name);
        user.setContact(contact);
        userRepository.save(user);
    }
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(String isbn){
        userRepository.deleteById(isbn);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void addAuthor(Author author)
    {
        authorRepository.save(author);
    }

}
