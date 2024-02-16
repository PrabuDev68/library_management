package com.springprojects.librarymanagement.librarian.controller;

import com.springprojects.librarymanagement.librarian.model.Author;
import com.springprojects.librarymanagement.librarian.model.Book;
import com.springprojects.librarymanagement.librarian.model.Genre;
import com.springprojects.librarymanagement.librarian.model.User;
import com.springprojects.librarymanagement.librarian.service.LibrarianService;
import com.springprojects.librarymanagement.librarian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/librarian-controller")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @GetMapping(value = "/books")
    public List<Book> getBooks(){
        return librarianService.getBooks();
    }

    @GetMapping(value = "/book/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn)
    {
        return librarianService.getBookByIsbn(isbn);
    }

    @GetMapping(value = "/book/title")
    public Book getBookByTitle(@RequestParam("title") String title)
    {
        return librarianService.getBookByTitle(title);
    }

    @GetMapping(value = "/genre/{genreType}/book")
    public List<Book> getBookByGenre(@PathVariable("genreType") String genreType)
    {
        return librarianService.getBooksByGenreType(genreType);
    }
    @GetMapping(value = "/author/{id}/book")
    public List<Book> getBookByAuthor(@PathVariable("id") String authorId)
    {
        return librarianService.getBooksByAuthorId(authorId);
    }

    @PostMapping(value = "/genre/{genreType}/author/{authorId}/book")
    public void addBook(@RequestBody Book book,@PathVariable String genreType,@PathVariable String authorId)
    {
        book.setAuthor(new Author(authorId,""));
        book.setGenre(new Genre(genreType,""));
        book.setAvailability(book.getAvailableBooks());
        librarianService.addBook(book);
    }
    @PostMapping(value = "/genre")
    public void addGenre(@RequestBody Genre genre)
    {
        librarianService.addGenre(genre);
    }
    @PostMapping(value = "/author")
    public void addAuthor(@RequestBody Author author)
    {
        librarianService.addAuthor(author);
    }

    @PutMapping(value = "/genre/{genreType}/author/{authorId}/book/{isbn}")
    public void updateBook(@RequestBody Book book,@PathVariable String genreType,@PathVariable String authorId,@PathVariable String isbn) {
        book.setAuthor(new Author(authorId,""));
        book.setGenre(new Genre(genreType,""));
        book.setAvailability(book.getAvailableBooks());
        librarianService.updateBook(book);
    }
    @DeleteMapping(value = "/genre/{genreType}/author/{authorId}/book/{isbn}")
    public void deleteBookById(@PathVariable String isbn)
    {
        librarianService.deleteBookByIsbn(isbn);
    }

    // USER MANAGEMENT
    @GetMapping(value = "/user")
    public List<User> getUser()
    {
        return librarianService.getUser();
    }
    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable String id)
    {
       return librarianService.getUserById(id);
    }
    @PostMapping(value = "/user")
    public void addUser(@RequestBody User user)
    {
        librarianService.addUser(user.getName(),user.getContact());
    }
    @PutMapping(value = "/user/{id}")
    public void updateUser(@RequestBody User user)
    {
        librarianService.updateUser(user);
    }
    @DeleteMapping(value = "/user/{id}")
    public void deleteUserById(@PathVariable String id){
        librarianService.deleteUserById(id);
    }



}
