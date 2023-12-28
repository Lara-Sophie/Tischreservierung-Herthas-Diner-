package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TischTest {

    @Test
    public void testEqualsAndHashCode() {
        Tisch tisch1 = new Tisch(1, 4, false);
        Tisch tisch2 = new Tisch(1, 4, false);
        Tisch tisch3 = new Tisch(2, 6, true);

        // Test equality
        assertEquals(tisch1, tisch2);
        assertNotEquals(tisch1, tisch3);

        // Test hash code consistency
        assertEquals(tisch1.hashCode(), tisch2.hashCode());
        assertNotEquals(tisch1.hashCode(), tisch3.hashCode());
    }

    @Test
    public void testSetters() {
        Tisch tisch = new Tisch(1, 4, false);

        // Change values using setters

        tisch.setAnzahlPlaetze(6);
        tisch.setReserviert(true);

        // Assert that values are updated
        assertEquals(1, tisch.getId());
        assertEquals(6, tisch.getAnzahlPlaetze());
        assertTrue(tisch.isReserviert());
    }
}
