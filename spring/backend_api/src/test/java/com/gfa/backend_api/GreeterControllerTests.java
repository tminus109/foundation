package com.gfa.backend_api;

import com.gfa.backend_api.controllers.GreeterController;
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

@WebMvcTest(GreeterController.class)
public class GreeterControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    @Test
    public void missingNameAndTitleReturnsError() throws Exception {
        this.mockMvc.perform(get("/greeter"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide a name and a title!")));
        verify(this.logService, times(1)).newLogEntry("/greeter", "name=null, title=null");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void missingTitleReturnsError() throws Exception {
        this.mockMvc.perform(get("/greeter?name=Jutka"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide a title!")));
        verify(this.logService, times(1)).newLogEntry("/greeter", "name=Jutka, title=null");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void missingNameReturnsError() throws Exception {
        this.mockMvc.perform(get("/greeter?title=president"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide a name!")));
        verify(this.logService, times(1)).newLogEntry("/greeter", "name=null, title=president");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void greeterHappyTest() throws Exception {
        this.mockMvc.perform(get("/greeter?name=Jutka&title=president"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Jutka, my dear president!")));
        verify(this.logService, times(1)).newLogEntry("/greeter", "name=Jutka, title=president");
        verifyNoMoreInteractions(this.logService);
    }
}
