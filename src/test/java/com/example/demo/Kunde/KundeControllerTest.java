package com.example.demo.Kunde;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KundeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private KundeService kundeService;

    @InjectMocks
    private KundeController kundeController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(kundeController).build();
    }

    @Test
    public void testCreateKunde() throws Exception {
        Kunde kunde = new Kunde();
        when(kundeService.save(any(Kunde.class))).thenReturn(kunde);

        mockMvc.perform(post("/kunden")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(kunde)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetKundeById() throws Exception {
        Kunde kunde = new Kunde();
        kunde.setId(1);
        when(kundeService.get(1)).thenReturn(kunde);

        mockMvc.perform(get("/kunden/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testDeleteKunde() throws Exception {
        doNothing().when(kundeService).delete(1);
        mockMvc.perform(delete("/kunden/1"))
                .andExpect(status().isOk());
    }
}
