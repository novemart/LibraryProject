package com.example.LibrarySpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;
// maps to Book table in the DB
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    //annotation needs to be present to mark Primary Key
    @Id
    private int book_id;

    private String isbn;

    private String title;

    private String author;

    private String book_desc;


    // one side of the 1-to-many relationship
    // for every book we will get the full member object representing the person who borrowed the book
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="member_id")
    Member member;


    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + book_desc + '\'' +
                ", member=" + member.getMember_id() +
                '}';
    }

}
