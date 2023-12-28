package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TischeTest {

    private Tische tische;

    @BeforeEach
    public void setUp() {
        // Initialize an empty list of Tisch before each test
        tische = new Tische(new LinkedList<>());
    }

    @Test
    public void testAddTisch_FirstSlotAvailable() {
        // Add a Tisch to the Tische with specific parameters
        tische.addTisch(4, false);

        // Assert that the list contains the added Tisch at the first slot
        assertEquals(1, tische.getTische().size());
        assertEquals(0, tische.getTische().get(0).getId()); // The ID should be set to 0
        assertEquals(4, tische.getTische().get(0).getAnzahlPlaetze());
        assertFalse(tische.getTische().get(0).isReserviert());
    }

    @Test
    public void testAddTisch_SecondSlotAvailable() {
        // Add a Tisch to the Tische with specific parameters
        tische.addTisch(4, false);

        // Add another Tisch to the Tische with specific parameters
        tische.addTisch(6, true);

        // Assert that the list contains both Tisch objects at their respective slots
        assertEquals(2, tische.getTische().size());
        assertEquals(0, tische.getTische().get(0).getId());
        assertEquals(1, tische.getTische().get(1).getId());
        assertEquals(4, tische.getTische().get(0).getAnzahlPlaetze());
        assertEquals(6, tische.getTische().get(1).getAnzahlPlaetze());
        assertFalse(tische.getTische().get(0).isReserviert());
        assertTrue(tische.getTische().get(1).isReserviert());
    }

    @Test
    public void testAddTisch_AllSlotsOccupied() {
        // Add three Tisch objects to the Tische with specific parameters
        tische.addTisch(4, false);
        tische.addTisch(6, true);
        tische.addTisch(8, false);

        // Add another Tisch to the Tische with specific parameters
        tische.addTisch(5, true);

        // Assert that the new Tisch is added at the end of the list
        assertEquals(4, tische.getTische().size());
        assertEquals(3, tische.getTische().get(3).getId());
        assertEquals(5, tische.getTische().get(3).getAnzahlPlaetze());
        assertTrue(tische.getTische().get(3).isReserviert());
    }

    @Test
    public void testDeleteTisch() {
        // Add a Tisch to the Tische with specific parameters
        Tisch tisch = new Tisch(1, 4, false);
        tische.getTische().add(tisch);

        // Delete the Tisch
        tische.deleteTisch(tisch);

        // Assert that the list no longer contains the deleted Tisch
        assertTrue(tische.getTische().isEmpty());
    }
}

