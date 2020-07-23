package Vehicles;

import org.junit.experimental.theories.ParameterSignature;

import Driving.Bike;

public class EBike extends Bike {
    private final Double recommendedpsi = (double) 30;
    private Double psi = recommendedpsi;
    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    @Override
    public Double getTopSpeed(){
        Double topspeed = 38.5;
        Double speedlost = recommendedpsi - psi;

        return topspeed - speedlost;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI, so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance){
        Double time = ((distance/getTopSpeed()) * 3600);
        if(psi > 20 && distance >= 30 ){
            Double psideduction = distance/30;
            if(psideduction > 10){
                psi -= 10;}
            else{
                psi -= psideduction;
            }}
        return time.intValue();
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure(){
        return psi.intValue();
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        psi = 30.00;
    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }

    @Override
    public String toString(){
        return getTirePressure().toString();
    }

    @Override
    public boolean equals(Object object){
        return this.toString().equals(object.toString());
    }
}
