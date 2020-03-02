package nl.han.oose.dea.rest.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HealthCheckResourceTest {
    HealthCheckResource sut;

    @BeforeEach
    public void setup() {
        sut = new HealthCheckResource();
    }

    @Test
    public void healthyTest() {
        String actualValue = sut.healthy();

        Assertions.assertEquals("Up & Running", actualValue);
    }

}