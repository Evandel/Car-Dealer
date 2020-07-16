import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transaction {
    private int id;
    private GregorianCalendar date;
    private Car car;
    private String salesPerson;
    private String type;
    private double price;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

    //Default constructor method
    public Transaction() {
        this.id = 0;
        this.price = 0;
        this.type = "";
        this.salesPerson = "";
        this.date = new GregorianCalendar(2019,01,01);
        }

    /*
    Main constructor method to initalize id, car, salesPerson,
    type, price, and date
    @param id - the transaction id
    @param car - The car in transaction
    @param person - The person from sales team
    @param type - the type of transaction
    @param price - The price of the car
    @param date - Date of transaction
    */
    public Transaction(int id, Car car, String person, String type, double price, GregorianCalendar date) {
        this.id = id;
        this.car = car;
        this.salesPerson = person;
        this.type = type;
        this.price = price;
        this.date = date;
    }

    /*
    Checks if 2 id's match
    @param id - the foriegn id
    */
    public boolean matchID(int id) {
        if (id == this.id)
            return true;
        return false;
    }

    /*
    Gets the transaction's id
    @Return id
    */
    public int getID() {
        return this.id;
    }

    /*
    Gets the transaction month
    @Return date's Calendar.MONTH
    */
    public int getMonth() {
        return this.date.get(Calendar.MONTH);
    }

    /*
    Gets the transaction day
    @Return date's Calendar.DAY_OF_MONTH
    */
    public int getDay() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }

    /*
    Gets the transaction date
    @Return date
    */
    public GregorianCalendar getDate() {
        return this.date;
    }

    /*
    Gets the transaction's car
    @Return car
    */
    public Car getCar() {
        return this.car;
    }

    /*
    Gets the transaction's seller
    @Return salesPerson
    */
    public String getSeller() {
        return this.salesPerson;
    }

    /*
    Gets the transaction price
    @Return price
    */
    public double getPrice() {
        return this.price;
    }

    /*
    Gets the transaction type
    @Return type
    */
    public String getType() {
        return this.type;
    }

    /*
    Displays the transaction's id, date, type, sales person and car
    @return A string of id, date, type, salesPerson, and car
    */
    public String display() {
        String ret = "ID: " + this.id  +" Date: " + sdf.format(this.date.getTime()) +
                    " Type: " + this.type + " Sales person: " + this.salesPerson + 
                    " Car: " + this.car.display(); 
        return ret;
    }
}