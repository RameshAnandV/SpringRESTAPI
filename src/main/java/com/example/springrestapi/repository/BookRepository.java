package com.example.springrestapi.repository;

import com.example.springrestapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
