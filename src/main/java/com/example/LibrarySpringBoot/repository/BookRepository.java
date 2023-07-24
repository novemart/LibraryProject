package com.example.LibrarySpringBoot.repository;

import com.example.LibrarySpringBoot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//creates a Spring Bean, only an interface, implementations generated at run time
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
