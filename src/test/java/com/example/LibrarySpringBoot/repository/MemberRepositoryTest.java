package com.example.LibrarySpringBoot.repository;

import com.example.LibrarySpringBoot.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@PropertySource("test-app.properties")
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepo;

    @Test
    public void findMembersByFirstName(){
        //arrange
        Member m = new Member();
        m.setName("Martina");
        m.setDate_joined(new Date());
        m.setPhone_num("01234567891");
        m.setEmail("martina@martina.com");
        memberRepo.save(m);

        Member m2 = new Member();
        m2.setName("NotMartina");
        m2.setDate_joined(new Date());
        m2.setPhone_num("01234567891");
        m2.setEmail("notmartina@martina.com");
        memberRepo.save(m2);

        //act
        List<Member> members = memberRepo.findByNameStartingWithLetter("N%");

        //assert
        assertEquals(1, members.size());
        assertEquals("NotMartina", members.get(0).getName());


    }
}
