package com.gfa.backend_api;

import com.gfa.backend_api.controllers.DoublingController;
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

@WebMvcTest(DoublingController.class)
public class DoublingControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    @Test
    public void inputEqualsFiveHappyTest() throws Exception {
        this.mockMvc.perform(get("/doubling?input=5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.received", is(5)))
                .andExpect(jsonPath("$.result", is(10)));
        verify(this.logService, times(1)).newLogEntry("/doubling", "input=5");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void nullInputReturnsError() throws Exception {
        this.mockMvc.perform(get("/doubling"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide an input!")));
        verify(this.logService, times(1)).newLogEntry("/doubling", "input=null");
        verifyNoMoreInteractions(this.logService);
    }
}
