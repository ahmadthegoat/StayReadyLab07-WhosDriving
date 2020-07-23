/**package Vehicles;
 import Driving.Car;

 public class HondaCivic extends Car {

 double milesSinceOilChange = 0.0;
 double distanceTraveled = 0.0;
 double TotalDistance
 double
 /**
 * A civic should need an oil change every
 * 50,000 miles traveled. Once the oil is
 * changed, the car may travel another 50,000
 * miles before needing another oil change.
 *
 * @return true if an oil change is needed
 *
 @Override
 public Boolean needsOilChange() {
 if(distanceTraveled >= 50000.0 && distanceTraveled)
 return milesSinceOilChange == 50000.0;
 }

 /**
  * This method should reset any flags set
  * from when an oil change was needed. It
  * should also indicate that another 50,000
  * miles may be traveled before another oil
  * change is needed.
 /
 @Override
 public void changeOil() {
 milesSinceOilChange = 0.0;
 }

 /**
  * the check engine light should be on whenever
  * something is wrong with the car. This class
  * simply turns on the light when an oil change
  * is needed.
  * @return true if anything is wrong with the car
/
 @Override
 public Boolean checkEngineLight() {
 return needsOilChange();
 }

 /**
  * This method should return the total distance
  * traveled by the car. This number can never
  * decrease, so every time it is called the newest
  * value returned should be equal to or higher
  * than all previous values.
  * @return total distance as a Double
/
 @Override
 public Double getDistanceTraveled() {
 return distanceTraveled;
 }

 /**
  * Should return the top speed for a Civic (70 MPH)
  * @return 70.0
/
 @Override
 //@Override
 public Double getTopSpeed() {
 return 70.0;
 }

 /**
  * transport should calculate the time it takes in
  * seconds to travel a distance base on the top
  * speed and update the amount of miles traveled.
  *
  * @param distance - length of travel in miles
 * @return time in seconds to travel distance
/
 @Override
 //@Override
 public Integer transport(Double distance) {
 return null;
 distanceTraveled += distance;
 milesSinceOilChange += distance;
 return (int)Math.round(distance / (getTopSpeed() / 3600));
 }
 }


 **/package Vehicles;

import Driving.Car;
import Driving.Drivable;

public class ToyotaCamary extends Car {
    private double topspeed = 95.00;
    private Double Previousdistance = 0.0;
    private Double TotalDistanceTraveled = 0.0;
    private  Boolean needOilchange = true;

    public void setPreviousdistance(Double distanceTraveled){
        this.Previousdistance = distanceTraveled;
    }
    public void setTotalDistanceTraveled(Double distanceTraveled){
        this.TotalDistanceTraveled += distanceTraveled;
    }

    public Double getTotalDistanceTraveled() {
        return TotalDistanceTraveled;
    }
    public Double getPreviousdistance(){
        return Previousdistance;
    }



    /**
     * A civic should need an oil change every
     * 50,000 miles traveled. Once the oil is
     * changed, the car may travel another 50,000
     * miles before needing another oil change.
     *
     * @return true if an oil change is needed
     **/
    @Override
    public Boolean needsOilChange() {
        double difference = 0;
        if(getTotalDistanceTraveled() != getPreviousdistance()){
            difference = getTotalDistanceTraveled() - getPreviousdistance();
            if(difference >= 100000.0){
                return  true;
            }
        }

        else if(getTotalDistanceTraveled() % 1000000 == 0.0 && getTotalDistanceTraveled() >= 100000.0){
            return true;
        }

        //if(difference < 50000){
        //  needOilchange = false;
        // }
        return false;

    }

    /**
     * This method should reset any flags set
     * from when an oil change was needed. It
     * should also indicate that another 50,000
     * miles may be traveled before another oil
     * change is needed.
     **/
    public void changeOil() {
        //this.setTotalDistanceTraveled(TotalDistanceTraveled += distanceTraveled);
        this.setPreviousdistance(getTotalDistanceTraveled());
        needOilchange = false;

        //System.out.println("Oil Changed!");
    }

    /**
     * the check engine light should be on whenever
     * something is wrong with the car. This class
     * simply turns on the light when an oil change
     * is needed.
     * @return true if anything is wrong with the car
     **/
    @Override
    public Boolean checkEngineLight() {
        return needsOilChange();
    }

    /**
     * This method should return the total distance
     * traveled by the car. This number can never
     * decrease, so every time it is called the newest
     * value returned should be equal to or higher
     * than all previous values.
     * @return total distance as a Double
     **/
    @Override
    public Double getDistanceTraveled() {
        return getTotalDistanceTraveled();
    }

    /**
     * Should return the top speed for a Civic (70 MPH)
     * @return 70.0
     **/
    @Override
    public Double getTopSpeed(){
        return topspeed;
    }

    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the amount of miles traveled.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     **/
    @Override
    public Integer transport(Double distance) {
        Double time = (distance/getTopSpeed() * 3600);
        //this.setDistanceTraveled(distance);
        this.setTotalDistanceTraveled(distance);
        return time.intValue();
    }

    @Override
    public String toString(){
        return getTotalDistanceTraveled().toString();
    }

    @Override
    public boolean equals(Object object){
        return this.toString().equals(object.toString());
    }
}
