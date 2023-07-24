package com.example.LibrarySpringBoot.repository;

import com.example.LibrarySpringBoot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// creates a Spring bean, implementation created at runtime
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

     // methods following JPA naming convention don't need to contain the SQL
     List<Member> findByName(String name);

     @Query(nativeQuery = true, value="select * from member where name like :letter")
     List<Member> findByNameStartingWithLetter(String letter);

}
