public class ElectricCar extends Car {
    private int rechargeTime;
    private String batteryType;

    /*
    Default constructor method
    */
    public ElectricCar() {
        this.rechargeTime = 0;
        this.batteryType = "";
    }

    /*
    Main constructor method to initalize VIN, manufacturer, color,
    power, numWheels, model, maxRange, safetyRating, 
    AWD, price, and rechargeTime.
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
    @param rechargeTime - the time to recharge the car
    */
    public ElectricCar(int VIN, String mfr, String color, Power power, int numWheels, Model model, int maxRange, double safetyRating, boolean AWD, double price,int rechargeTime) {
        super(VIN,mfr,color,power,numWheels,model,maxRange,safetyRating,AWD,price);
        this.rechargeTime = rechargeTime;
        this.batteryType = "Lithium";
    }

    /*
    Sets the recharge time
    @param time - New recharge time
    */
    public void setRechargeTime(int time) {
        this.rechargeTime = time;
    }

    /*
    Sets the battery time
    @param type - New battery type
    */
    public void setBatteryType(String type) {
        this.batteryType = type;
    }

    /*
    Gets the recharge time
    @return rechargeTime;
    */
    public int getRechargeTime() {
        return rechargeTime;
    }

    /*
    Gets the battery type
    @return batteryType
    */
    public String getBatteryType() {
        return batteryType;
    }

    /*
    Displays the vehicle's VIN, manufacturer, color, power, 
    model, maxRange, safetyRating, AWD, price,
    rechargeTime and batteryType.
    @return A string of VIN, manufacturer, color, power, 
    model, maxRange, safetyRating, AWD, price,
    rechargeTime and batteryType
    */
    public String display() {
        return super.display() + " RCH:" + this.rechargeTime + " BAT:" + this.batteryType;
    }
    
}