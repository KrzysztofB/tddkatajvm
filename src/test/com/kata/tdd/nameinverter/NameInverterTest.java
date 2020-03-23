package com.kata.tdd.nameinverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameInverterTest {

    private NameInverter nameInverter;

    @BeforeEach
    void setUp() {
        nameInverter = new NameInverter();
    }

    @Test
    void shoudThrowExceptionWhenNullProvided() {
        assertThrows(NullPointerException.class,
                () -> nameInverter.invert(null));
    }

    @Test
    void shouldReturnEmptyWhenEmptyGiven() {
        String result = nameInverter.invert("");
        assertEquals("", result);
    }
}