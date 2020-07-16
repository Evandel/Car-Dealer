import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class CarDealership {
    ArrayList<Car>cars = new ArrayList<Car>();
    AccountingSystem accSystem = new AccountingSystem();
    SalesTeam team = new SalesTeam();
    private boolean filterElectric = false;;
    private boolean filterAWD = false;
    private boolean filterPrice = false;
    private double minPrice = 0;
    private double maxPrice = 0;
    private boolean contains = false;

    /*
    Default constructor method to initalize arraylist of cars
    */
    public CarDealership() {
        ArrayList<Car>cars = new ArrayList<Car>();
        AccountingSystem accSystem = new AccountingSystem();
        SalesTeam team = new SalesTeam();
    }

    /*
    Add an ArrayList of cars to ArrayList initialized in constructor
    @param newCars - ArrayList of cars
    */
    public void addCars(ArrayList<Car> newCars) {
        cars.addAll(newCars);
    }


    /*
    gives the accountingSystem
    @return accSystem
    */
    public AccountingSystem retS() {
        return accSystem;
    }

    /*
    Checks if the car is in the Accounting System
    */
    public boolean ifCarIn() {
        if (contains)
            return true;
        else return false;
    }

    /*
    Buy a car from the dealership
    @param VIN - VIN number of the car you want to buy
    */
    public Car buyCar(int VIN) throws Exception {
        Car ret = new Car();
        this.contains = false;
        for (int i = 0;i<cars.size();i++) {
            if (cars.get(i).getVIN() == VIN) {
                this.contains = true;
                ret = cars.get(i);
                cars.remove(i);
            }
        }
        if (this.contains == true) {
            String person = team.seller();
            GregorianCalendar date = new GregorianCalendar();
            date.set(Calendar.YEAR, 2019);
            date.set(Calendar.DAY_OF_YEAR,
            new Random().nextInt(date.getActualMaximum(Calendar.DAY_OF_YEAR) + 1));
            accSystem.add(date,ret,person,"BUY",ret.getPrice());
            return ret;
        }
        else {
            throw new Exception();        
        }
    }

    
    /*
    Return the last car bought
    @param transaction - the transaction id of car u want to return
    */
    public void returnCar(int transaction) {
        //Transaction trans = this.accSystem.getTransaction(this.accSystem.getLastKey());
        Transaction trans = this.accSystem.getTransaction(transaction);
        
        Random rnd = new Random();
        int month = 0;
        int day = 0;
        while (month < trans.getMonth())
            month = rnd.nextInt(12);
        day = rnd.nextInt(28) + 1;
        if (month == trans.getMonth()) {
            while (day < trans.getDay())
                day = rnd.nextInt(28) + 1;
        }
        GregorianCalendar date = new GregorianCalendar(2019,month,day);
        accSystem.add(date,trans.getCar(),trans.getSeller(),"RET",trans.getPrice());
        cars.add(trans.getCar());
    }

    /*
    Returns inventory size
    @return cars.size()
    */
    public int inventorySize() {
        return cars.size();
    }

    /*
    Displays inventory(ArrayList) of cars. Print varies on which
    filters are on or not.
    */
    public void displayInventory() {
        for (int i = 0;i < cars.size();i++) {
            if (filterAWD) {
                if (cars.get(i).getAWD() != true)
                    continue;
                }
            if (filterPrice) {
                if (!(cars.get(i).getPrice() >= this.minPrice && cars.get(i).getPrice() <= this.maxPrice)) 
                    continue;
            }
            
            if (filterElectric) {
                if(!(cars.get(i).getPower().equals(Vehicle.Power.ELECTRIC_MOTOR)))
                    continue;
            }
            
        //System.out.println(i +" " + cars.get(i).display());
        System.out.println(cars.get(i).display());
        }  
    }  

    /*
    Turns on the electric filter for displayInventory
    */
    public void filterByElectric() {
        this.filterElectric = true;
    }

    /*
    Turns on the AWD filter for displayInventory
    */
    public void filterByAWD() {
        this.filterAWD = true;
    }

    /*
    Turns on price filter for displayInventory.
    @param minPrice - minimum price for filter
    @param maxPrice - maximum price for filter
    */
    public void filterByPrice(double minPrice, double maxPrice) {
        this.filterPrice = true;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    /*
    Clears all filters
    */
    public void filtersClear() {
        this.filterAWD = false;
        this.filterElectric = false;
        this.filterPrice = false;
    }

    /*
    Sorts inventory(ArrayList) by price in ascending order
    */
    public void sortByPrice() {
        Collections.sort(cars);
    }

    /*
    Inner class that implements Comparator to compare 
    safetyRating of 2 cars.
    @param other1 - first car to compare
    @param other2 - second car to compare
    */
    class SafetyRatingSorter implements Comparator<Car>{
        public int compare(Car other1, Car other2) {
            if (other1.getSR() > other2.getSR()) return 1;
            if (other1.getSR() < other2.getSR()) return -1;
            return 0;
        }
    }

    /*
    Inner class that implements Comparator to compare 
    maxRange of 2 cars.
    @param other1 - first car to compare
    @param other2 - second car to compare
    */
    class MaxRangeSorter implements Comparator<Car>{
        public int compare(Car other1, Car other2) {
            return Integer.compare(other1.getMR(), other2.getMR());
        }
    }

    /*
    Sorts inventory(ArrayList) by safetyRating in ascending order
    */
    public void sortBySafetyRating() {
        Collections.sort(cars, new SafetyRatingSorter());
    }

    /*
    Sorts inventory(ArrayList) by maxRange in ascending order
    */
    public void sortByMaxRange() {
        Collections.sort(cars, new MaxRangeSorter());
    }

    /*
    gives all transactions for the year
    @return accSystem.allSales()
    */
    public String sales() {
        return accSystem.allSales();
    }

    /*
    gives all sales team members 
    @return team.meetTheTeam()
    */
    public String salesTeam() {
        return team.meetTheTeam();
    }

    /*
    prints the top sales person
    */
    public void topSP() {
        accSystem.topSP();
    }


    /*
    prints the transactions for a given month
    @param m - the given month
    */
    public void monthlySales(int m) {
        accSystem.salesMonths(m);
    }

    /*
    prints the total stats for the year
    */
    public void stats() {
        accSystem.salesStats();
    }

}