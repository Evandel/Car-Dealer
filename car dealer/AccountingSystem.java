//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;

class AccountingSystem {
    private TreeMap<Integer, Transaction> system;
    private ArrayList<Integer> keys;
    SalesTeam team;

    //Default constructor method
    public AccountingSystem() {
        system = new TreeMap<Integer, Transaction>();
        keys = new ArrayList<Integer>();
        SalesTeam team = new SalesTeam();
    }

    /*
    Main constructor method to initalize a transaction and store 
    into the accounting system.
    @param date - Date of transaction
    @param car - The car in transaction
    @param salesPerson - The person from sales team
    @param type - the type of transaction
    @param salesPrice - The price of the car
    */
    public String add(GregorianCalendar date, Car car, String salesPerson, String type, double salesPrice) {
        int id;
        Transaction trans;
        Random rnd = new Random();
        id = rnd.nextInt(99) + 1;
        keys.add(id);
        trans = new Transaction(id, car, salesPerson, type, salesPrice, date);
        system.put(id, trans);
        return trans.display();
    }

    /*
    Gets the transaction when given the transaction id
    @return given transaction from accounting system 
    */
    public Transaction getTransaction(int id) {
        return system.get(id);
    }

    /*
    Gives all transactions for the year
    @return result - String of all transaction for the year
    */
    public String allSales() {
        String result = "All Transactions: \n";
        int count = 0;
        Set<Integer> sales = system.keySet();
        for (Integer key : sales) {
            count++;
            result += system.get(key).display() + "\n";
        }
        return result;
    }

    /*
    Prints the top sales person and the number of cars they sold
    */
    public void topSP() {
		int mostSales = 0;
		Map<String, Integer> salesPerson = new TreeMap<String, Integer>();
        for (Map.Entry<Integer, Transaction> set: system.entrySet()) {
			Transaction trans = set.getValue();
			String person = trans.getSeller();
			if (salesPerson.get(person) == null) 
				salesPerson.put(person, 1);
			else 
				salesPerson.put(person, salesPerson.get(person) + 1);
			if (salesPerson.get(person) > mostSales) 
                mostSales = salesPerson.get(person);
		}
		for (Map.Entry<String, Integer> set : salesPerson.entrySet()) {
			String name = set.getKey();
			int num = set.getValue();
			if (num == mostSales) 
				System.out.println("Top seller: " + name + "\nNumber of cars sold: " + num);
		}
    }

    /*
    Prints the sales for a given month
    @param m - the month you would like to see the transaction of
    */
    public void salesMonths(int m) {
        //int count = 0;
        for (Map.Entry<Integer, Transaction> set : system.entrySet()) {
            Transaction trans = set.getValue();
            Date date = trans.getDate().getTime();
            int key = set.getKey();
			if (date.getMonth() == m) {
                System.out.println(system.get(key).display() + "\n");
				//count++;
			}
		}
    }

    /*
    Prints the total stats for the year
    */
    public void salesStats() {
        Map<String, Integer> highestM = new TreeMap<String, Integer>();
		int sales = 0;
        int ret = 0;		
        int mostSales = 0;		
		double total = 0;
		for (Map.Entry<Integer, Transaction> set : system.entrySet()) {
			Transaction trans = set.getValue();
			if (trans.getType().equals("BUY")) {
				total += trans.getPrice();
				sales++;
				String m = new DateFormatSymbols().getMonths()[trans.getDate().getTime().getMonth()];
				if (highestM.get(m) == null) 
					highestM.put(m, 1);
				else 
					highestM.put(m, highestM.get(m) + 1);
				if (highestM.get(m) > mostSales) 
					mostSales = highestM.get(m);
			}
			else 
				ret++;
		}		
		String bestMonth = "";
		for (Map.Entry<String, Integer> set : highestM.entrySet()) {
			String month = set.getKey();
			int num = set.getValue();
			if (num == mostSales) 
                bestMonth = month;
        }
        System.out.println("Total stats of the year:\nTotal sales($ value): $" + total +
                            "\nAverage sale($ value) per month: $" + total/12 + 
                            "\nNumber of cars sold: " + sales + "\nHighest sales month: " +
                            bestMonth + "\nCars returned: " + ret);
    }
    
    /*
    Removes the last key from ArrayList of keys for the TreeMap
    */
    public void removeLastKey() {
        if (keys.size() > 0)
            keys.remove(keys.size()-1);
        System.out.println(keys);
    }

    /*
    gives the size of the ArrayList of keys
    @return keys.size()
    */
    public int keysSize() {
        return keys.size();
    }

    /*
    gets the last key in the ArrayList of keys 
    @return size of ArrayList
    */
    public int getLastKey() {
        return keys.get(keys.size() -1);
    }

}