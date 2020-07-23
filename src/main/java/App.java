import Driving.Drivable;
import Vehicles.HondaCivic;
import Vehicles.MountainBike;

import java.util.Scanner;

public class App {
    static int appExecutionStatus = -1;

    /**
     * main App, runs the application
     * If the first element of args is "test" then the
     * app will run using a scanner that is made of
     * input passed into the second element
     *
     * If no errors occur, then the final line of the method
     * will change the appExecutionStatus variable to 0;
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (args[0].equals("test"))
            in = new Scanner(args[1]);
        Console c = new Console(in);

        System.out.println("What kinda of vehicle do you want to drive");
        Drivable vehicle = getVehicle(c);

        System.out.println("How far do you want to travel");
        Double distance = getDistance(c);

        Integer timeTraveled = vehicle.transport(distance);

        System.out.println(String.format("You traveled for %d seconds", timeTraveled));
        App.appExecutionStatus = 0;
    }

    /**
     * This method should return a new instance of a Drivable.
     * The input received should be representative of a class
     * that implements Drivable. E.G. the input "honda civic"
     * should return an instance of a HondaCivic
     *
     * @param c
     * @return input from Console c as Drivable
     */
    public static Drivable getVehicle(Console c) {
        String input = c.getInput();
        Drivable drivable;
        if(input.equalsIgnoreCase("mountain bike")){
            drivable = new MountainBike();
        }
        else{
            drivable = new HondaCivic();
        }
        return drivable;
    }

    /**
     * This method get input from the console and convert it to
     * a double. This double represents a distance a user wants
     * to travel in a specified vehicle.
     * @param c
     * @return Input from Console c as Double
     */
    public static Double getDistance(Console c) {
        String input = c.getInput();
        return Double.parseDouble(input);
    }
}
