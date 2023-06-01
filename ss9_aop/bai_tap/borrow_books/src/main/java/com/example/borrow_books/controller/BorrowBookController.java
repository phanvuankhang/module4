package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowBook;
import com.example.borrow_books.service.IBookService;
import com.example.borrow_books.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BorrowBookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookService iBorrowBookService;

    @GetMapping("")
    public String displayList(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "home";
    }

    @GetMapping("/borrow")
    public String borrowBook(Model model, @RequestParam(value = "id", defaultValue = "0") Long id, RedirectAttributes redirectAttributes) {
        if (id == 0) {
            throw new RuntimeException("Invalid book ID");
        }

        Book book = iBookService.findBookById(id);

        String codeBorrowBook;
        boolean checkCodeBorrowBook;
        int maxAttempts = 100; // Giới hạn số lần lặp
        int attemptCount = 0;

        do {
            checkCodeBorrowBook = true;
            codeBorrowBook = iBorrowBookService.generateRandomCode();

            List<BorrowBook> borrowBooks = iBorrowBookService.findAll();

            for (BorrowBook borrowBook : borrowBooks) {
                if (borrowBook.getCodeBorrowBook().equals(codeBorrowBook)) {
                    checkCodeBorrowBook = false;
                    break;
                }
            }

            attemptCount++;
        } while (!checkCodeBorrowBook && attemptCount < maxAttempts);

        if (!checkCodeBorrowBook) {
            throw new RuntimeException("Unable to generate unique borrow code");
        }

        BorrowBook borrowBook = new BorrowBook(book, codeBorrowBook, false);
        boolean statusBorrowBook = iBorrowBookService.saveBorrowBook(borrowBook);
        iBookService.updateBorrow(id);

        return "redirect:/";
    }

    @GetMapping("return-book")
    public String returnBookInfo(Model model) {
        model.addAttribute("borrowBookList", iBorrowBookService.findAll());
        return "return_book";
    }

    @PostMapping("return-book")
    public String returnBook(@RequestParam("codeBorrowBook") String codeBorrowBook, RedirectAttributes redirectAttributes) {
        BorrowBook borrowBook = iBorrowBookService.returnBook(codeBorrowBook);
        if (borrowBook != null) {
            iBookService.updateReturn(borrowBook.getBook().getId());
            redirectAttributes.addFlashAttribute("statusReturnBook", true);
            return "redirect:/return-book";
        } else {
            throw new RuntimeException("");
        }
    }

    @ExceptionHandler(Exception.class)
    public String exception() {
        return "error";
    }
}