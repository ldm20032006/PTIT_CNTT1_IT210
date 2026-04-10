package org.example.session06.controller;

import org.example.session06.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Book 1", "Author 1", 10.0));
        books.add(new Book(2, "Book 2", "Author 2", 300000.0));
        books.add(new Book(3, "Book 3", "Author 3", 30.0));
    }

    @GetMapping
    public String showListBook(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String showBookDetail(@PathVariable("id") Integer id, Model model) {
        Book book = books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        model.addAttribute("book", book);
        return "detail";
    }
}
