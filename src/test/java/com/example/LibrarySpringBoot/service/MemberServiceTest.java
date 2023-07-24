package com.example.LibrarySpringBoot.service;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNull;


@SpringBootTest
public class MemberServiceTest {

    @MockBean
    MemberRepository mockRepo;

    @Autowired
    MemberService memberService;

    @Test
    public void getOneByIdReturnsNewIfNegative(){
        //arrange
        int id = -1;

        //act
        Member member = memberService.getOneById(id);

        //assert
        assertNull("Name should be null", member.getName());
    }

    @Test
    public void getOneByIdReturnsMember(){
        //arrange
        int id = 1;
        Member newMember = new Member();
		newMember.setEmail("martina@sky.com");
		newMember.setPhone_num("07537245367");
		newMember.setName("Martina");
        newMember.setDate_joined(new Date());
        Optional<Member> optMem = Optional.of(newMember);
        when(mockRepo.findById(1)).thenReturn(optMem);

        //act
        Member member = memberService.getOneById(id);

        //assert
        assertEquals("Martina", member.getName());
        verify(mockRepo, times(1)).findById(1);

    }
}
