package nl.han.oose.dea.rescources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthCheckResourceTest {

    private HealthCheckResource healthCheckResourceUnderTest;

    @BeforeEach
    void setUp() {
        healthCheckResourceUnderTest = new HealthCheckResource();
    }

    @Test
    void testHealthy() {
        // Setup

        // Run the test
        final String result = healthCheckResourceUnderTest.healthy();

        // Verify the results
        assertEquals("Up & Running!", result);
    }
}
