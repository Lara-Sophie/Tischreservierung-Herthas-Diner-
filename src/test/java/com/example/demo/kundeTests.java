

package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

    class kundeTests {

        @Test
        void testEqualsAndHashCode() {
            LinkedList<Tischreservierung_herthas_diner> reservations1 = new LinkedList<>();
            LinkedList<Tischreservierung_herthas_diner> reservations2 = new LinkedList<>();

            Kunde kunde1 = new Kunde(1, "John", "john@example.com", "123456789", reservations1);
            Kunde kunde2 = new Kunde(1, "John", "john@example.com", "123456789", reservations2);

            // Test equals method
            assertTrue(kunde1.equals(kunde2));
            assertTrue(kunde2.equals(kunde1));

            // Test hashCode method
            assertEquals(kunde1.hashCode(), kunde2.hashCode());
        }

        @Test
        void testGettersAndSetters() {
            LinkedList<Tischreservierung_herthas_diner> reservations = new LinkedList<>();
            Kunde kunde = new Kunde(1, "John", "john@example.com", "123456789", reservations);

            // Test getters
            assertEquals(1, kunde.getId());
            assertEquals("John", kunde.getName());
            assertNull(kunde.getAllergien());
            assertEquals("john@example.com", kunde.getEmail());
            assertEquals("123456789", kunde.getTelefonnummer());
            assertEquals(reservations, kunde.getTischreservierung_herthas_diner());

            // Test setters
            kunde.setName("Jane");
            kunde.setAllergien(new LinkedList<>());
            kunde.setEmail("jane@example.com");
            kunde.setTelefonnummer("987654321");

            assertEquals("Jane", kunde.getName());
            assertNotNull(kunde.getAllergien());
            assertEquals("jane@example.com", kunde.getEmail());
            assertEquals("987654321", kunde.getTelefonnummer());
        }
    }

