package com.example.LibrarySpringBoot.controller;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    MemberService memberService;
    @GetMapping("/book")
    public String getBook(){
        return "myFirstView";
    }

    @GetMapping("/mems")
    public ModelAndView showCategories(){
        List<Member> mems = memberService.getAllMembers();
        ModelAndView mav = new ModelAndView("members.html");
        mav.addObject("members", mems);
        return mav;
    }
}
