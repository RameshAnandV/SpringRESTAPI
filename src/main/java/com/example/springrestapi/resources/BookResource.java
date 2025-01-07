package com.example.springrestapi.resources;

import com.example.springrestapi.models.Book;
import com.example.springrestapi.services.BookService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource {

    private BookService bookService;
    private MessageSource messageSource;

    public BookResource(BookService bookService, MessageSource messageSource) {
        this.bookService = bookService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBook/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }
}
