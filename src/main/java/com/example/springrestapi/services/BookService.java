package com.example.springrestapi.services;

import com.example.springrestapi.exceptions.NotFoudException;
import com.example.springrestapi.models.Book;
import com.example.springrestapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    MessageSource messageSource;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Integer id) {
        Optional<Book> books = bookRepository.findById(id);
        Locale locale = LocaleContextHolder.getLocale();
        if (books.isEmpty()) {
            throw new NotFoudException(messageSource.getMessage("not.found", null, "Resource with id not found", locale) + id);
        }
        return books.get();
    }

    public ResponseEntity addBook(Book book) {
        book = bookRepository.save(book);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getBook/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
