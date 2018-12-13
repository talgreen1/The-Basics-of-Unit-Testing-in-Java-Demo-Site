package com.talgreen.demosite.controller;

import com.talgreen.demosite.model.Book;
import com.talgreen.demosite.service.BookStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("v1/books")
public class BookStoreController {

    private BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookStoreService.getBooks();
    }
}
