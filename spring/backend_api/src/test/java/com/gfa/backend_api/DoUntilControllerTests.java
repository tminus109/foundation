package com.gfa.backend_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfa.backend_api.controllers.DoUntilController;
import com.gfa.backend_api.models.Until;
import com.gfa.backend_api.services.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(DoUntilController.class)
public class DoUntilControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void missingOperationPathVariableReturnsNotFound() throws Exception {
        this.mockMvc.perform(post("/dountil/{operation}", ""))
                .andExpect(status().isNotFound());
        verifyNoInteractions(this.logService);
    }

    @Test
    public void untilEqualsZeroReturnsError() throws Exception {
        this.mockMvc.perform(post("/dountil/{operation}", "sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new Until(0))))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide a number!")));
        verify(this.logService, times(1)).newLogEntry("/dountil/{operation}", "operation=sum, until=0");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void operationEqualsSumHappyTest() throws Exception {
        this.mockMvc.perform(post("/dountil/{operation}", "sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new Until(5))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is(15)));
        verify(this.logService, times(1)).newLogEntry("/dountil/{operation}", "operation=sum, until=5");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void operationEqualsFactorHappyTest() throws Exception {
        this.mockMvc.perform(post("/dountil/{operation}", "factor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(new Until(5))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is(120)));
        verify(this.logService, times(1)).newLogEntry("/dountil/{operation}", "operation=factor, until=5");
        verifyNoMoreInteractions(this.logService);
    }
}
