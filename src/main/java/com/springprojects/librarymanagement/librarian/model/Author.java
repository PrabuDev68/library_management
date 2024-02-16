package com.springprojects.librarymanagement.librarian.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @UuidGenerator
    private String id;
    private String authorName;

    public Author(){

    }

    public Author(String id,String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
