package com.example.demo.Reservierung;

import com.example.demo.Kunde.Kunde;
import com.example.demo.Kunde.KundeRepository;
import com.example.demo.ReservierungTische.ReservierungTischeRepository;
import com.example.demo.Tisch.Tisch;
import com.example.demo.Tisch.TischRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;



class ReservierungServiceTest {

    @Mock
    private ReservierungRepository reservierungRepository;

    @Mock
    private TischRepository tischRepository;

    @Mock
    private ReservierungTischeRepository reservierungTischeRepository;

    @Mock
    private KundeRepository kundeRepository;

    @InjectMocks
    private ReservierungService reservierungService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createReservierung_Success() throws InvalidReservationTimeException, TableNotAvailableException {
        // Arrange
        Integer kundenId = 1;
        List<Integer> tischIds = Arrays.asList(1, 2);
        LocalDateTime startZeit = LocalDateTime.now();
        LocalDateTime endZeit = startZeit.plusHours(2);
        int personen = 4;

        Kunde mockKunde = new Kunde();
        mockKunde.setId(kundenId);
        when(kundeRepository.findById(kundenId)).thenReturn(Optional.of(mockKunde));

        List<Tisch> mockTische = tischIds.stream().map(id -> {
            Tisch t = new Tisch();
            t.setId(id);
            return t;
        }).collect(Collectors.toList());
        when(tischRepository.findAllById(tischIds)).thenReturn(mockTische);

        when(reservierungTischeRepository.findReservierungTischeByTischIdAndStartzeitBetweenAndEndzeitBetween(anyInt(), any(), any()))
                .thenReturn(Collections.emptyList());

        Reservierung mockReservierung = new Reservierung();
        when(reservierungRepository.save(any(Reservierung.class))).thenReturn(mockReservierung);

        // Act
        Reservierung result = reservierungService.createReservierung(kundenId, tischIds, startZeit, endZeit, personen);

        // Assert
        assertNotNull(result);
    }

    @Test
    void createReservierung_InvalidTimeRange() {
        // Implement test logic here
    }

    @Test
    void createReservierung_TableNotAvailable() {
        // Implement test logic here
    }

    @Test
    void deleteReservierung_Success() {
        // Implement test logic here
    }

    @Test
    void deleteReservierung_NonExistent() {
        // Implement test logic here
    }
}

