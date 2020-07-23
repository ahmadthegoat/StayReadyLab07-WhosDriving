package Driving;

public interface Drivable {

    /**
     * Gets the top speed of the drivable vehicle
     *
     * The top speed should be assumed to be miles per hour
     *
     * @return top speed in miles per hour
     */
    Double getTopSpeed();

    /**
     * Gets the time in seconds the vehicle takes to travel a distance
     *
     * @param distance - length of travel in miles
     * @return Integer time in seconds
     */
    Integer transport(Double distance);
    
}
