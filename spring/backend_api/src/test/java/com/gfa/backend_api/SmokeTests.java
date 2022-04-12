package com.gfa.backend_api;

import com.gfa.backend_api.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTests {
    @Autowired
    private AppendAController appendAController;
    @Autowired
    private ArrayHandlerController arrayHandlerController;
    @Autowired
    private DoublingController doublingController;
    @Autowired
    private DoUntilController doUntilController;
    @Autowired
    private GreeterController greeterController;
    @Autowired
    private LogController logController;
    @Autowired
    private MainController mainController;

    @Test
    public void appendAControllerLoads() throws Exception {
        assertThat(appendAController).isNotNull();
    }

    @Test
    public void arrayHandlerControllerLoads() throws Exception {
        assertThat(arrayHandlerController).isNotNull();
    }

    @Test
    public void doublingControllerLoads() throws Exception {
        assertThat(doublingController).isNotNull();
    }

    @Test
    public void doUntilControllerLoads() throws Exception {
        assertThat(doUntilController).isNotNull();
    }

    @Test
    public void greeterControllerLoads() throws Exception {
        assertThat(greeterController).isNotNull();
    }

    @Test
    public void logControllerLoads() throws Exception {
        assertThat(logController).isNotNull();
    }

    @Test
    public void mainControllerLoads() throws Exception {
        assertThat(mainController).isNotNull();
    }
}
