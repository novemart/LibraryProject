package com.example.LibrarySpringBoot.controller;

import com.example.LibrarySpringBoot.model.Member;
import com.example.LibrarySpringBoot.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @MockBean
    MemberService mockedService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllMembersTest() throws Exception{
        //arrange
        Member m = new Member();
        m.setName("Martina");
        m.setDate_joined(new Date());
        m.setPhone_num("01234567891");
        m.setEmail("martina@martina.com");

        Member m2 = new Member();
        m2.setName("John");
        m2.setDate_joined(new Date());
        m2.setPhone_num("01234567891");
        m2.setEmail("martina@martina.com");

        List<Member> members = new ArrayList<>();
        members.add(m);
        members.add(m2);

        when(mockedService.getAllMembers()).thenReturn(members);

        //act
        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                //assert
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("Martina"))
                .andExpect(jsonPath("$[1].name").value("John"));
    }

    @Test
    public void addMemberTest() throws Exception {
        Member m = new Member();
        m.setName("Martina");
        m.setDate_joined(new Date());
        m.setPhone_num("01234567891");
        m.setEmail("martina@martina.com");

        when(mockedService.saveNewMember(any())).thenReturn(m);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/members")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(m))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }
}
