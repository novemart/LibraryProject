package com.example.LibrarySpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;
import java.util.Optional;
// maps to Book table in the DB
@Entity
public class Book {

    //annotation needs to be present to mark Primary Key
    @Id
    private int book_id;

    private String isbn;

    private String title;

    private String author;


    private String book_desc;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // one side of the 1-to-many relationship
    // for every book we will get the full member object representing the person who borrowed the book
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="member_id")
    Member member;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_desc() {
        return book_desc;
    }

    public void setBook_desc(String desc) {
        this.book_desc = desc;
    }



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
