package com.example.borrow_books.service;

import com.example.borrow_books.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();

    boolean saveBorrowBook(BorrowBook borrowBook);

    BorrowBook returnBook(String codeBorrowBook);
}
