package com.springprojects.librarymanagement.librarian.controller;

import com.springprojects.librarymanagement.librarian.model.User;
import com.springprojects.librarymanagement.librarian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-controller")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping(value = "user/{id}/book/{isbn}/borrow")
    public Boolean borrowBook(@PathVariable String id,@PathVariable String isbn)
    {
        return userService.borrowBook(id,isbn);
    }

    @PutMapping(value = "user/{id}/book/{isbn}/return")
    public Boolean returnBook(@PathVariable String id,@PathVariable String isbn)
    {
        return userService.returnBook(id,isbn);
    }
}
