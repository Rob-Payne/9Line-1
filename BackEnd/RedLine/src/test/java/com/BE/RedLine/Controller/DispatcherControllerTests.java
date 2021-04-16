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
public class DispatcherControllerTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    RequestRepo requestRepository;

    @Test
    @Transactional
    @Rollback
    public void getAllRequestsTest() throws Exception{
        Request newRequest = new Request("Location1","Callsign1","Urgent Surgical","None","Ambulatory");
        requestRepository.save(newRequest);

        MockHttpServletRequestBuilder getAllRequests = get("/requests")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getAllRequests)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].location",is("Location1")));
    }

    @Test
    @Transactional
    @Rollback
    public void getRequestByIdTest() throws Exception{
        Request newRequest = new Request("Location2","Callsign2","Urgent Surgical","None","Ambulatory");
        Long newRequestId = requestRepository.save(newRequest).getId();

        MockHttpServletRequestBuilder getById = get("/requests/"+newRequestId)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(getById)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location",is("Location2")));
    }

    @Test
    @Transactional
    @Rollback
    public void patchRequestByIdTest() throws Exception{
        Request newRequest = new Request("Location5","Callsign5","Urgent Surgical","None","Ambulatory");
        Long newRequestId = requestRepository.save(newRequest).getId();

        //check that entry exists
        MockHttpServletRequestBuilder checkRequest = get("/requests/"+newRequestId)
            .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(checkRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());

        //patch entry
        MockHttpServletRequestBuilder patchRequest = patch("/requests/"+newRequestId)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"responder\":\"RandomCallsign\"}");

        this.mvc.perform(patchRequest)
                .andExpect(status().isOk());

        //check results
        MockHttpServletRequestBuilder checkPatchSuccessful = get("/requests/"+newRequestId)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(checkPatchSuccessful)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responder",is("RandomCallsign")));

    }




}
