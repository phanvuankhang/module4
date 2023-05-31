package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findBookById(Long id);

    void updateBorrow(Long id);

    void updateReturn(Long id);
}

