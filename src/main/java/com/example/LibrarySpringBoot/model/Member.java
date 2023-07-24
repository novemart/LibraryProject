package com.example.LibrarySpringBoot.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
//mapping to Member table in the DB
@Entity
public class Member {

    //primary key field annotation, generates the value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;

    private String name;

    private String phone_num;

    private String email;

    private Date date_joined;

    // this annotation will recreate one side of the 1-to-many relationship
    // for every memebr we will get a list of their borrowed books
    @OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    List<Book> borrowedBooks;

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }


    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", email='" + email + '\'' +
                ", date_joined=" + date_joined +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
