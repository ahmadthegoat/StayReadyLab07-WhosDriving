package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EBikeTest {
    EBike mb;

    @Before
    public void setUp() throws Exception {
        this.mb = new EBike();
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 38.5;

        // Act
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransport() {
        // Arrange
        Double expected = 36.5;

        // Act
        mb.transport(30.0);
        mb.transport(30.0);
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTopSpeedAfterTransportThenInflateTires() {
        // Arrange
        Double expected = 38.5;

        // Act
        mb.transport(30 * 2.0);
        mb.inflateTires();
        Double actual = mb.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = (60 * 60);

        // Act
        Integer actual = mb.transport(38.5);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure() {
        // Arrange
        Integer expected = 28;

        // Act
        mb.transport(30.0 * 2);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure2() {
        // Arrange
        Integer expected = 27;

        // Act
        mb.transport(30.0 * 3);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure3() {
        // Arrange
        Integer expected = 20;

        // Act
        mb.transport(30.0 * 100);
        mb.transport(30.0 * 2);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transportTirePressure4() {
        // Arrange
        Integer expected = 30;

        // Act
        mb.transport(29.9);
        mb.transport(29.9);
        mb.transport(29.9);
        mb.transport(29.9);
        mb.transport(29.9);
        mb.transport(29.9);
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = mb.getTirePressure();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void inflateTires() {
        // Arrange
        Integer expected = 30;

        // Act
        mb.transport(30.0 * 3);
        Integer tirePressureAfterTransport = mb.getTirePressure();

        mb.inflateTires();
        Integer actual = mb.getTirePressure();

        // Assert
        assertNotEquals(expected, tirePressureAfterTransport);
        assertEquals(expected, actual);
    }

    @Test
    public void recommendedTirePressure() {
        // Arrange
        Integer expected = 30;

        // Act
        Integer actual = mb.recommendedTirePressure();

        // Assert
        assertEquals(expected, actual);
    }
}