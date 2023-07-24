package com.example.LibrarySpringBoot.service;

import com.example.LibrarySpringBoot.model.Book;
import com.example.LibrarySpringBoot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// creates a Spring bean, this is the business layer
@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

}
