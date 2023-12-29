package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

class KundenTest {

    @Test
    void testEqualsAndHashCode() {
        LinkedList<Kunde> kunden1 = new LinkedList<>();
        LinkedList<Kunde> kunden2 = new LinkedList<>();

        kunden1.add(new Kunde(1, "John", "john@example.com", "123456789", new LinkedList<>()));
        kunden1.add(new Kunde(2, "Jane", "jane@example.com", "987654321", new LinkedList<>()));

        kunden2.add(new Kunde(1, "John", "john@example.com", "123456789", new LinkedList<>()));
        kunden2.add(new Kunde(2, "Jane", "jane@example.com", "987654321", new LinkedList<>()));

        Kunden kundenObj1 = new Kunden(kunden1);
        Kunden kundenObj2 = new Kunden(kunden2);

        // Test equals method
        assertTrue(kundenObj1.equals(kundenObj2));
        assertTrue(kundenObj2.equals(kundenObj1));

        // Test hashCode method
        assertEquals(kundenObj1.hashCode(), kundenObj2.hashCode());
    }
    @Test
    void testAddKunde() {
        Kunden kunden = new Kunden(new LinkedList<>());

        // Add a Kunde
        kunden.addKunde("John", "john@example.com", "123456789", new LinkedList<>());
        assertEquals(1, kunden.getKunden().size());

        // Add another Kunde
        kunden.addKunde("Jane", "jane@example.com", "987654321", new LinkedList<>());
        assertEquals(2, kunden.getKunden().size());

        // Verify the details of the added Kundes
        Kunde john = kunden.getKunden().get(0);
        assertEquals("John", john.getName());
        assertEquals("john@example.com", john.getEmail());
        assertEquals("123456789", john.getTelefonnummer());

        Kunde jane = kunden.getKunden().get(1);
        assertEquals("Jane", jane.getName());
        assertEquals("jane@example.com", jane.getEmail());
        assertEquals("987654321", jane.getTelefonnummer());
    }
    @Test
    void testAddAndDeleteKunde() {
        Kunden kunden = new Kunden(new LinkedList<>());

        // Add a Kunde
        kunden.addKunde("John", "john@example.com", "123456789", new LinkedList<>());
        assertEquals(1, kunden.getKunden().size());

        // Add another Kunde
        kunden.addKunde("Jane", "jane@example.com", "987654321", new LinkedList<>());
        assertEquals(2, kunden.getKunden().size());

        // Delete a Kunde
        Kunde john = kunden.getKunden().get(0);
        kunden.deleteKunde(john);
        assertEquals(1, kunden.getKunden().size());
        assertFalse(kunden.getKunden().contains(john));
    }
}
