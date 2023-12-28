package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class tischeTests {

    @Before
    public void setUp() {
        // Initialize your class instance before each test
        tischeInstance = new Tische();
    }
    @Test
    public void testAddTisch_Success() {
        Tisch tisch = new Tisch(/* Initialize Tisch object with unique ID */);
        tischeInstance.addTisch(tisch);

        // Assert that the list contains the added Tisch
        assertTrue(tischeInstance.getTische().contains(tisch));
    }

    @Test
    public void testAddTisch_IdAlreadyExists() {
        // Add a Tisch with a specific ID
        Tisch existingTisch = new Tisch(/* Initialize Tisch object with a specific ID */);
        tischeInstance.addTisch(existingTisch);

        // Attempt to add another Tisch with the same ID
        Tisch tischWithSameId = new Tisch(existingTisch.getId());
        tischeInstance.addTisch(tischWithSameId);

        // Assert that the message "Ein Tisch mit dieser ID existiert bereits." is printed to the console
        // You may need to capture the console output for more accurate testing
        // For simplicity, let's assume there's a method getConsoleOutput() in Tische
        assertEquals("Ein Tisch mit dieser ID existiert bereits.", tischeInstance.getConsoleOutput().trim());
    }
}