package com.example.borrow_books.service.impl;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepository;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void updateBorrow(Long id) {
        iBookRepository.updateBorrow(id);
    }

    @Override
    public void updateReturn(Long id) {
        iBookRepository.updateReturn(id);
    }
}

