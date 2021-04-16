package com.BE.RedLine.Controller;

import com.BE.RedLine.DAO.RequestRepo;
import com.BE.RedLine.Model.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.bind.annotation.PatchMapping;

@SpringBootTest
@AutoConfigureMockMvc
class ResponderControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    RequestRepo requestRepository;

    @Test
    @Transactional
    @Rollback
    public void getMyRequestsTest() throws Exception {
        Request newRequest1 = new Request("Location5","Callsign5","Urgent Surgical","None","1-Ambulatory");
        newRequest1.setResponder("Bill");
        Long newRequest1Id = requestRepository.save(newRequest1).getId();
        Request newRequest2 = new Request("Location5","Callsign5","Urgent Surgical","None","1-Ambulatory");
        newRequest2.setResponder("Steve");
        Long newRequest2Id = requestRepository.save(newRequest2).getId();



        MockHttpServletRequestBuilder getRequestByResponder1 = get("/responder/Bill")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getRequestByResponder1)
                .andExpect(jsonPath("$[0].responder",is("Bill")));

        MockHttpServletRequestBuilder getRequestByResponder = get("/responder/Steve")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getRequestByResponder)
                .andExpect(jsonPath("$[0].responder",is("Steve")));
    }
}
