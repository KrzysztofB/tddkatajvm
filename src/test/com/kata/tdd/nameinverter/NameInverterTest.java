package com.kata.tdd.nameinverter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInverterTest {

    private NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @AfterEach
    void tearDown() {
        nameInverter = null;
    }

    @Test
    void shouldReturnEmptyWhenEmptyGiven() {
        String result = nameInverter.invert("");
        assertEquals("", result);
    }
}