package com.example.demo.Kunde;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class KundeServiceTest {

    @Mock
    private KundeRepository kundeRepository;

    @InjectMocks
    private KundeService kundeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveKunde() {
        Kunde kunde = new Kunde();
        when(kundeRepository.save(any(Kunde.class))).thenReturn(kunde);
        Kunde result = kundeService.save(kunde);
        assertNotNull(result);
    }

    @Test
    public void testGetKundeById() {
        Kunde kunde = new Kunde();
        kunde.setId(1);
        when(kundeRepository.findById(1)).thenReturn(Optional.of(kunde));
        Kunde result = kundeService.get(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    public void testDeleteKunde() {
        doNothing().when(kundeRepository).deleteById(1);
        kundeService.delete(1);
        verify(kundeRepository, times(1)).deleteById(1);
    }
}
