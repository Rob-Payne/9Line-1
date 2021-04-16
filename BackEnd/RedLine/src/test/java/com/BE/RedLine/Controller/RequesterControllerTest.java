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
class RequesterControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    RequestRepo requestRepository;

    @Test
    @Transactional
    @Rollback
    public void createNineLineTest() throws Exception {
        MockHttpServletRequestBuilder createRequest = post("/nineline")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"location\":\"Location1\",\"callSign\":\"Callsign1\"," +
                        "\"patientUrgency\":\"Urgent\",\"specialEquipment\":\"Jungle Penetrator\"," +
                        "\"patientType\":\"1-Ambulatory, 2-Litter\",\"security\":\"X-Armed Escort Required\"," +
                        "\"hlzMarking\":\"Smoke\",\"nationality\":\"3-US\",\"nbc\":\"None\"}");

        this.mvc.perform(createRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.specialEquipment", is("Jungle Penetrator")))
                .andExpect(jsonPath("$.nbc", is("None")));
    }



}