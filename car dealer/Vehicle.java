import java.util.Random;

public class Vehicle {
    private String mfr;
    private String color;
    private Power power;
    private int numWheels;
    private int VIN;
    public static final int GAS_ENGINE = 0;
    public static final int ELECTRIC_MOTOR = 1;
    public enum Power {
        GAS_ENGINE, ELECTRIC_MOTOR
    }

    //Default constructor method
    public Vehicle() {
        this.mfr = "";
        this.color = "";
        this.power = Power.GAS_ENGINE;
        this.numWheels = 4;
        this.VIN = 100;
    }

    /*
    Main constructor method to initialize VIN,manufacturer, color, power, wheel number.
    @param VIN - the VIN number of vehicle
    @param mfr - The manufacturer
    @param color - The color of vehicle
    @param power - The vehicle power type
    @numWheels - the number of wheels of vehicle
    */ 
    public Vehicle(int VIN, String mfr, String color, Power power, int numWheels) {
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.numWheels = numWheels;
        Random rnd = new Random();
        //this.VIN = rnd.nextInt(400) + 100;
        this.VIN = VIN;
    }

    /*
    Sets manufacturer
    @param mfr - The new manufacturer
    */
    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    /*
    Sets color
    @param color - The new color
    */
    public void setColor(String color) {
        this.color = color;
    }

    /*
    Sets power
    @param power - the new Power type
    */
    public void setPower(Power power) {
        this.power = power;
    }

    /*
    Sets number of wheels
    @param numWheels - the new number of wheels
    */
    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    /*
    Gets the power type
    @return power
    */
    public Power getPower() {
        return power;
    }

    /*
    Gets the number of wheels
    @return numWheels
    */
    public int getNumWheels() {
        return numWheels;
    }

    /*
    Gets the manufacturer
    @return mfr
    */
    public String getMfr() {
        return mfr;
    }

    /*
    Gets the color
    @return color
    */
    public String getColor() {
        return color;
    }

    /*
    Gets the VIN number
    @return VIN
    */
    public int getVIN() {
        return VIN;
    }

    /*
    Compares if 2 vehicles are the same by
    checking if their mfr, color and power
    and equal.
    @param other - Object class other
    */
    public boolean equals(Object other) {
        Vehicle newV = (Vehicle)other;
        if (newV.getMfr().equals(this.mfr) && newV.getPower() == this.power && newV.getNumWheels() == this.numWheels)
            return true;
        else return false;
    }

    /*
    Displays the vehicle's VIN, manufacturer, color and power
    @return A string of VIN, manufacturer, color and power
    */
    public String display() {
        return this.VIN + " " + this.mfr + " " + this.color + " " + this.power;
    }


}