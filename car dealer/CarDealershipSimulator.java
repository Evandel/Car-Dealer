//Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;


//Tester class
public class CarDealershipSimulator 
{
  public static void main(String[] args) throws Exception
  {
	  // Create a CarDealership object
		CarDealership deals = new CarDealership();
		AccountingSystem system = new AccountingSystem();
		// Then create an (initially empty) array list of type Car
		ArrayList<Car>newCars = new ArrayList<Car>();
		// Then create some new car objects of different types 
		//Imports cars from a .txt file
		try {
			Scanner scanner = new Scanner(new File("cars.txt"));
			Car car;
			ElectricCar ecar;
			while(scanner.hasNext())
			{
				Random random = new Random();
				int VIN = random.nextInt(400)+100;
				String mfr = scanner.next();
				String color = scanner.next();
				String type = scanner.next();
				String engine = scanner.next();
				double sr = Double.parseDouble(scanner.next());
				int mr = Integer.parseInt(scanner.next());
				String AllWheelDrive = scanner.next();
				boolean awd;
				if(AllWheelDrive.equals("AWD")) 
					awd = true;
				else 
					awd = false;
				int price = Integer.parseInt(scanner.next());
				if(engine.equals("GAS_ENGINE")) {
					if (type.equals("SEDAN"))
						car = new Car(VIN,mfr,color,Vehicle.Power.GAS_ENGINE,4,Car.Model.SEDAN,mr,sr,awd,price);
					else if (type.equals("SPORTS"))
						car = new Car(VIN,mfr,color,Vehicle.Power.GAS_ENGINE,4,Car.Model.SPORTS,mr,sr,awd,price);
					else if (type.equals("MINIVAN"))
						car = new Car(VIN,mfr,color,Vehicle.Power.GAS_ENGINE,4,Car.Model.MINIVAN,mr,sr,awd,price);
					else 
						car = new Car(VIN,mfr,color,Vehicle.Power.GAS_ENGINE,4,Car.Model.SUV,mr,sr,awd,price);
					newCars.add(car);
				}
				else {
					int recharge = Integer.parseInt(scanner.next());
					if (type.equals("SEDAN"))
						ecar = new ElectricCar(VIN,mfr,color,Vehicle.Power.ELECTRIC_MOTOR,4,Car.Model.SEDAN,mr,sr,awd,price,recharge);
					else if (type.equals("SPORTS"))
					ecar = new ElectricCar(VIN,mfr,color,Vehicle.Power.ELECTRIC_MOTOR,4,Car.Model.SPORTS,mr,sr,awd,price,recharge);
					else if (type.equals("MINIVAN"))
					ecar = new ElectricCar(VIN,mfr,color,Vehicle.Power.ELECTRIC_MOTOR,4,Car.Model.MINIVAN,mr,sr,awd,price,recharge);
					else 
					ecar = new ElectricCar(VIN,mfr,color,Vehicle.Power.ELECTRIC_MOTOR,4,Car.Model.SUV,mr,sr,awd,price,recharge);
					newCars.add(ecar);
				}
				
			}
			}
			catch(FileNotFoundException e) {
				System.out.println("file not found");
			}
			
		ArrayList<Car>returns = new ArrayList<Car>();
		ArrayList<Integer>keys = new ArrayList<Integer>();
		returns.add(newCars.get(newCars.size() - 1));
		boolean returnCheck = false;
		int count = 0;

		System.out.println("\t~Car Dealership Sim~");
		//System.out.println("Note - Commands must be in all caps");
		System.out.println("Commands: \nL - List Inventory\nADD - add cars\nBUY (VIN) - buys the car via VIN" +
											"\nQ - quit\nRET - return last bought car\nSPR - " +
											"sort by price\nSSR - sort by safety rating\nSMR - " +
											"sort my max range\nFPR - filter by price\nFEL - " +
											"filter by electric\nFAW - filter by all wheel drive\n" +
											"FCL - clear all filters\nSALES - displays all sales for " +
											"2019\nSALES TEAM - introduces you to our team!\nSALES m" +
											" - displays sales for a given month\nSALES STATS - " +
											"displays all super important stats for the year 2019\nSALES TOPSP" +
											" - displays the top sales person\nHELP - displays list of commands");
		System.out.println("---------------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
	  String command = in.nextLine().toUpperCase();
		while (command != null) {
			if(command.equals("L")) {
				System.out.println("~Inventory~");
				deals.displayInventory();
			}

			else if(command.equals("HELP")) {
				System.out.println("Commands: \nL - List Inventory\nADD - add cars" +
				"\nQ - quit\nBUY - buys the car via VIN\nRET - return last bought car\nSPR - " +
				"sort by price\nSSR - sort by safety rating\nSMR - " +
				"sort my max range\nFPR - filter by price\nFEL - " +
				"filter by electric\nFAW - filter by all wheel drive\n" +
				"FCL - clear all filters\nSALES - displays all sales for " +
				"2019\nSALES TEAM - introduces you to our team!\nSALES m" +
				" - displays sales for a given month\nSALES STATS - " +
				"displays all super important stats for the year 2019\nSALES TOPSP" +
				" - displays the top sales person\nHELP - displays list of commands");
				System.out.println("---------------------------------------------------------------------");
			}

			else if(command.equals("ADD")) {
				deals.addCars(newCars);
				System.out.println("Added cars");
			}

			else if(command.equals("Q")) {
				System.out.println("Goodbye");
				return;
			}

			else if(command.contains("BUY")) {
				StringTokenizer p = new StringTokenizer(command);
				p.nextToken();
				if(p.hasMoreTokens()) {
					try {
						int i = Integer.parseInt(p.nextToken());
							Car last = deals.buyCar(i);
							system = deals.retS();
							returns.set(0,last);
							if (deals.ifCarIn() == true) {
								returnCheck = true;
								keys.add(system.getLastKey());
								System.out.println("Bought car \n" + system.getTransaction(keys.get(keys.size() -1)).display());
							}
							else System.out.println("Invalid input");
						}
					
					catch (Exception e) {
						System.out.println("Invalid VIN");
					}
				}
				else
					System.out.println("Invalid input");
			}

			else if (command.equals("RET")) {
				if (returnCheck) {
					deals.returnCar(keys.get(keys.size() -1));
					keys.remove(keys.size()-1);
					returnCheck = false;
					System.out.println("Car returned");
				}
				else
					System.out.println("Nothing to return");
			}

			else if (command.equals("SPR")) {
				deals.sortByPrice();
				System.out.println("Sorted by price");
			}

			else if (command.equals("SSR")) {
				deals.sortBySafetyRating();
				System.out.println("Sorted by safety rating");
			}

			else if (command.equals("SMR")) {
				deals.sortByMaxRange();
				System.out.println("Sorted by max range");
			}

			else if (command.equals("FEL")) {
				deals.filterByElectric();
				System.out.println("Filtered by Electric");
			}

			else if (command.equals("FAW")) {
				deals.filterByAWD();
				System.out.println("Filtered by AWD");
			}

			else if (command.contains("FPR")) {
				try {
					double min = in.nextDouble();
					double max = in.nextDouble();
					if (min >= 0 && min <= max) {
						deals.filterByPrice(min, max);
						System.out.println("Filtered by price");
					}
					else 	
						System.out.println("Invalid prices");
				}

				catch (InputMismatchException e) {
					System.out.println("Invalid index");
				}
			}
				
			else if (command.equals("FCL")) {
				deals.filtersClear();
				System.out.println("All filters cleared");
			}

			else if (command.contains("SALES")) {
				StringTokenizer p = new StringTokenizer(command);
				p.nextToken();
				if(p.hasMoreTokens()) {
					String s = p.nextToken();
					if(!p.hasMoreTokens()) {
						if(s.equals("TEAM")) {
							System.out.println(deals.salesTeam());
						}
						else if(s.equals("TOPSP")) {
							deals.topSP();
						}
						else if (s.equals("STATS")) {
							deals.stats();
						}
						else {
							try {
								int i = Integer.parseInt(s);
								String m = "";
								if(i<0 || i>11)
									throw new Exception();
								switch(i) {
								case 0: m = "January";
									break;
								case 1: m = "February";
									break;
								case 2: m = "March";
									break;
								case 3: m = "April";
									break;
								case 4: m = "May";
									break;
								case 5: m = "June";
									break;
								case 6: m = "July";
									break;
								case 7: m = "August";
									break;
								case 8: m = "September";
									break;
								case 9: m = "October";
									break;
								case 10: m = "November";
									break;
								case 11: m = "December";
									break;
								}
								System.out.println("All transactions of " + m);
								deals.monthlySales(i);
							}
							catch(Exception e) {
								System.out.println("Invalid input");
						}
					}
				}
			}
			else if (!p.hasMoreTokens())
			System.out.println(deals.sales());
		}

		  command = in.nextLine().toUpperCase();


		}
	

			}
		
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  
	  
	  // Create a scanner object
	  
	  // while the scanner has another line
	  //    read the input line
	  //    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
	  //    read the next word from the commandLine scanner 
      //	check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object  
		}
	

