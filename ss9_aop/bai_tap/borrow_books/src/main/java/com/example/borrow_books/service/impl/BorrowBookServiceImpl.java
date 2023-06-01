package com.example.borrow_books.service.impl;

;
import com.example.borrow_books.model.BorrowBook;
import com.example.borrow_books.repository.IBorrowBookRepository;
import com.example.borrow_books.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BorrowBookServiceImpl implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;

    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepository.findAll();
    }

    @Override
    public boolean saveBorrowBook(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
        return true;
    }

    @Override
    public BorrowBook returnBook(String codeBorrowBook) {
        List<BorrowBook> borrowBooks = iBorrowBookRepository.findAllBorrowBook();
        for (int i = 0; i < borrowBooks.size(); i++) {
            if (borrowBooks.get(i).getCodeBorrowBook().equals(codeBorrowBook)) {
                iBorrowBookRepository.upadteBorrowBook(codeBorrowBook);
                return borrowBooks.get(i);
            }
        }
        return null;
    }

    @Override
    public String generateRandomCode() {
        int min = 10000;
        int max = 99999;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return String.valueOf(randomNum);
    }
}