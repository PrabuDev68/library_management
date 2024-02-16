package com.springprojects.librarymanagement.librarian.service;

import com.springprojects.librarymanagement.librarian.model.Author;
import com.springprojects.librarymanagement.librarian.model.Book;
import com.springprojects.librarymanagement.librarian.model.Genre;
import com.springprojects.librarymanagement.librarian.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibrarianService {

    public void addBook(Book book);
    public void updateBook(Book book);
    public void deleteBookByIsbn(String Isbn);
    public List<Book> getBooks();
    public Book getBookByIsbn(String isbn);
    public List<Book> getBooksByGenreType(String genreType);
    public Book getBookByTitle(String title);
    public List<Book> getBooksByAuthorId(String authorId);
    public void addUser(String name,String contact);
    public void updateUser(User user);


    void deleteUserById(String isbn);

    public List<User> getUser();


    User getUserById(String id);

    void addGenre(Genre genre);

    void addAuthor(Author author);
}
