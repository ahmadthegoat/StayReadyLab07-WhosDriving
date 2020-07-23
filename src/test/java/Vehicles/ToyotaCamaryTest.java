package Vehicles;

import Driving.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyotaCamaryTest {

    Car toyotacamary = new ToyotaCamary();

    @Before
    public void setUp() throws Exception {
        this.toyotacamary = new ToyotaCamary();
    }

    @Test
    public void needsOilChange() {
        // Arrange

        // Act
        Boolean newCivicNeedsOilChange = toyotacamary.needsOilChange();
        // Assert
        assertFalse(newCivicNeedsOilChange);
    }

    @Test
    public void needsOilChangeAfterTravel() {
        // Arrange
        toyotacamary.transport(100000.0);
        // Act
        Boolean needsOilAfter50kMiles = toyotacamary.needsOilChange();
        // Assert
        assertTrue(needsOilAfter50kMiles);
    }

    @Test
    public void needsOilChangeAfterTravelThenOilChange() {
        // Arrange
        toyotacamary.transport(200000.5);
        // Act
        toyotacamary.changeOil();
        Boolean needsOilChangeAfterOilChange = toyotacamary.needsOilChange();
        // Assert
        assertFalse(needsOilChangeAfterOilChange);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel49kMiles() {
        // Arrange
        toyotacamary.transport(200000.0);
        // Act
        toyotacamary.changeOil();
        toyotacamary.transport(49000.0);
        Boolean oilNeedsChanging49kMiles = toyotacamary.needsOilChange();

        // Assert
        assertFalse(oilNeedsChanging49kMiles);
    }

    @Test
    public void needsOilChangeAfterOilChangeThenTravel2000kMiles() {
        // Arrange
        toyotacamary.transport(200000.0);
        // Act
        toyotacamary.changeOil();
        toyotacamary.transport(200000.0);
        Boolean oilNeedsChanging150kMiles = toyotacamary.needsOilChange();

        // Assert
        assertTrue(oilNeedsChanging150kMiles);
    }

    @Test
    public void checkEngineLight() {
        // Arrange
        toyotacamary.transport(200000.0);
        // Act
        Boolean checkEngineLightIsOn = toyotacamary.checkEngineLight();

        // Assert
        assertTrue(checkEngineLightIsOn);
    }

    @Test
    public void checkEngineLight2() {
        // Arrange
        toyotacamary.transport(40000.0);
        // Act
        Boolean checkEngineLightIsOn = toyotacamary.checkEngineLight();

        // Assert
        assertFalse(checkEngineLightIsOn);
    }

    @Test
    public void getTopSpeed() {
        // Arrange
        Double expected = 95.0;
        // Act
        Double actual = toyotacamary.getTopSpeed();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void transport() {
        // Arrange
        Integer expected = 2 * 60 * 60;
        // Act
        Integer actual = toyotacamary.transport(95.0 * 2);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveled() {
        // Arrange
        Double expected = 300.0;
        // Act
        toyotacamary.transport(300.0);
        Double actual = toyotacamary.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getDistanceTraveledNewCar() {
        // Arrange
        Double expected = 0.0;
        // Act
        Double actual = toyotacamary.getDistanceTraveled();

        // Assert
        assertEquals(expected, actual);
    }
}
