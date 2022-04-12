package com.gfa.backend_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfa.backend_api.models.ArrayHandlerInput;
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
public class ArrayHandlerControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LogService logService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void whatEqualsSumInputHappyTest() throws Exception {
        ArrayHandlerInput input = new ArrayHandlerInput("sum", new int[]{1, 2, 5, 10});
        this.mockMvc.perform(post("/arrays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(input)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is(18)));
        verify(this.logService, times(1)).newLogEntry("/arrays", input.toString());
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void whatEqualsMultiplyInputHappyTest() throws Exception {
        ArrayHandlerInput input = new ArrayHandlerInput("multiply", new int[]{1, 2, 5, 10});
        this.mockMvc.perform(post("/arrays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(input)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is(100)));
        verify(this.logService, times(1)).newLogEntry("/arrays", input.toString());
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void whatEqualsDoubleInputHappyTest() throws Exception {
        ArrayHandlerInput input = new ArrayHandlerInput("double", new int[]{1, 2, 5, 10});
        this.mockMvc.perform(post("/arrays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(input)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", is(36)));
        verify(this.logService, times(1)).newLogEntry("/arrays", input.toString());
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void whatIsNullInputReturnsError() throws Exception {
        ArrayHandlerInput input = new ArrayHandlerInput(null, new int[]{1, 2, 5, 10});
        this.mockMvc.perform(post("/arrays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(input)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide what to do with the numbers!")));
        verify(this.logService, times(1)).newLogEntry("/arrays", input.toString());
        verifyNoMoreInteractions(this.logService);
    }

    @Test
    public void numbersIsNullInputReturnsError() throws Exception {
        ArrayHandlerInput input = new ArrayHandlerInput("double", null);
        this.mockMvc.perform(post("/arrays")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(input)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("Please provide what to do with the numbers!")));
        verify(this.logService, times(1)).newLogEntry("/arrays", input.toString());
        verifyNoMoreInteractions(this.logService);
    }
}
