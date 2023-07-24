package com.example.LibrarySpringBoot.service;

import com.example.LibrarySpringBoot.exception.InvalidIdException;
import com.example.LibrarySpringBoot.exception.MemberNotFoundException;
import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//creates a Spring bean, business layer containing some validation, checks, processing...
@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepo;

    public List<Member> getAllMembers(){
        return memberRepo.findAll();
    }

    public Member getOneById(int id){
        if (id>0){
            Optional<Member> optMem = memberRepo.findById(id);
            return optMem.orElseThrow(()->new MemberNotFoundException("Member does not exist!"));
        }
        else {
            throw new InvalidIdException("That id is invalid");
        }
    }

    public List<Member> findMembersByFirstLetterName(char letter){
        return memberRepo.findByNameStartingWithLetter(letter+"%");
    }

    public Member saveNewMember(Member newMember) {
        newMember.setDate_joined(new Date());
        return memberRepo.save(newMember);
    }


}
