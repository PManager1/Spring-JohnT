package guru.springframework.spring6webapp.controllers;

import guru.springframework.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {

    private final BookService bookService;   // I am using the interface here, so we can run multiple implementations of it.

// this setsup the books service to be injected.
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }


}
