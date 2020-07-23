package Driving;

public abstract class Car implements Drivable {
    /**
     * Cars eventually need their oil changed.
     * Most cars simply need oil after a certain
     * amount of distance has been traveled but
     * some may have extra requirements
     *
     * @return true if an oil change is needed
     */
    public abstract Boolean needsOilChange();
       
    /**
     * When a car gets an oil change, this method
     * should reset flags that are raised when
     * oil became stagnant.
     */
    public abstract void changeOil();

    /**
     * The check engine light should turn on
     * if the car needs any maintenance. The
     * most common maintenance that a car
     * will usually need is an oil change
     * @return true | false
     */
    public abstract Boolean checkEngineLight();

    /**
     * The distance a car traveled should be
     * kept track of. A car's total distance
     * traveled should never decrease so
     * every time the method is called it should
     * return a value that is either equal to
     * or greater than all previous returns
     *
     * @return the total number of miles traveled
     */
    public abstract Double getDistanceTraveled();
}
