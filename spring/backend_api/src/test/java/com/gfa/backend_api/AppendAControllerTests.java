package com.gfa.backend_api;

import com.gfa.backend_api.services.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppendAControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    @Test
    public void happyTest() throws Exception {
        this.mockMvc.perform(get("/appenda/kuty"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.appended", is("kutya")));
        verify(this.logService, times(1)).newLogEntry("/appenda/{appendable}", "input=kuty");
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void unhappyTest() throws Exception {
        this.mockMvc.perform(get("/appenda/{appendable}", ""))
                .andExpect(status().isNotFound());
        verifyNoInteractions(this.logService);
    }
}
