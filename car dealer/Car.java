//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Car extends Vehicle implements Comparable<Car>{
    private Model model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD;
    private double price;
    public static final int SEDAN = 0;
    public static final int SUV = 1;
    public static final int SPORTS = 2;
    public static final int MINIVAN = 3;
    public enum Model {
        SEDAN, SUV, SPORTS, MINIVAN
    }

    /*
    Default constructor method
    */
    public Car() {
        this.maxRange = 0;
        this.safetyRating = 0;
        this.AWD = false;
        this.price = 0;
        this.model = Model.SEDAN;
    }

    /*
    Main constructor method to initalize VIN, manufacturer, color,
    power, numWheels, model, maxRange, safetyRating, 
    AWD, and price.
    @param VIN - the VIN number
    @param mfr - The manufacturer
    @param color - The color of vehicle
    @param power - The vehicle power type
    @param numWheels - the number of wheels of vehicle
    @param model - The car model
    @param maxRange - The max range of car
    @param safetyRating - The safety rating of car
    @param AWD - If car does all wheel drive
    @param price - The price of car
    */
    public Car(int VIN, String mfr, String color,Power power, int numWheels, Model model, int maxRange, double safetyRating, boolean AWD, double price) {
        super(VIN,mfr,color,power,numWheels);
        this.maxRange= maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;
        this.model = model;
    }

    /*
    Displays the vehicle's VIN, manufacturer, color, power, 
    model, maxRange, safetyRating, AWD, and price.
    @return A string of VIN, manufacturer, color, power, 
    model, maxRange, safetyRating, AWD, and price.
    */
    public String display() {
        return super.display() + " " + this.model + " RNG:" + this.maxRange + " SF:" + this.safetyRating + " AWD:" + this.AWD + " $" + this.price;
    }

    /*
    Compares if 2 cars are the same by
    checking if their model and AWD
    and equal.
    @param other - Object class other
    */
    public boolean equals(Object other) {
        Car newC = (Car)other;
        boolean test = super.equals(newC);
        if (test) {
            if (newC.getModel().equals(this.model) && newC.getAWD() == this.AWD)
                return true;
            else 
                return false;
            }
        return false;
    }

    /*
    Comparable method to compare 2 car's prices
    @param Car other
    */
    public int compareTo(Car other) {
        if (this.price > other.price) return 1;
        if (this.price < other.price) return -1;
        return 0;
    }

    /*
    Gets the safety rating
    @return safetyRating
    */
    public double getSR() {
        return this.safetyRating;
    }

    /*
    Gets the max range
    @return maxRange
    */
    public int getMR() {
        return this.maxRange;
    }

    /*
    Checks if car has all wheel drive
    @return AWD
    */
    public boolean getAWD() {
        return this.AWD;
    }

    /*
    Gets the price
    @return price
    */
    public double getPrice() {
        return this.price;
    }
    
    /*
    Gets the model
    @return model
    */
    public Model getModel() {
        return this.model;
    }
}