package com.gfa.backend_api;

import com.gfa.backend_api.controllers.LogController;
import com.gfa.backend_api.services.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(LogController.class)
public class LogControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/log"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.entries").exists())
                .andExpect(jsonPath("$.entries").isArray())
                .andExpect(jsonPath("$.entry_count").exists())
                .andExpect(jsonPath("$.entry_count").isNumber());
        verify(this.logService, times(1)).getLogs();
        verifyNoMoreInteractions(this.logService);
    }
}
