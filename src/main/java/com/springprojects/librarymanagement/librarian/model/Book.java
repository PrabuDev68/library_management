package com.springprojects.librarymanagement.librarian.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn;
    private String title;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private Author author;
    private Boolean availability;
    private Integer availableBooks;
    @ManyToMany(mappedBy = "borrowedBooks")
     private Set<User> borrowers = new HashSet<>();

    Book(){

    }
    public Book(String isbn, String title, String genreType,String authorId,Integer availableBooks) {
        this.isbn = isbn;
        this.title = title;
        this.genre = new Genre(genreType,"");
        this.author = new Author(authorId,"");
        this.availableBooks = availableBooks;
        if(availableBooks > 0)
            this.availability = true;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public Integer getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(Integer availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void setAvailability(Integer availableBooks) {
        this.availability = availableBooks > 0;
    }

    public Set<User> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<User> borrowers) {
        this.borrowers = borrowers;
    }
}
