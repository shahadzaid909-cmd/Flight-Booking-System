package flight.booking.system;

import java.util.*;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Main {

    static ArrayList<Flight> flightList = new ArrayList<Flight>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        
        int choice = 0;
        Booking b = null;
        Flight flight = null;
        Listexample(flightList);

        System.out.println("*** WELCOME TO FLIGHT BOOKING SYSTEM *** ");

        do {
            try {

                menu();
                choice = input.nextInt();
                switch (choice) {

                    // Add Flight
                    case 1:

                        System.out.println("choose your flight type :\n1.EconomyFlight\n2.Business Flight\n3.First class Flight");
                        int FlightType = input.nextInt();

                        if (FlightType < 1 || FlightType > 3) {
                            System.out.println("invalid choice!");
                        }

                        System.out.print("Enter the flight number: ");
                        String flightNum = input.next();
                        input.nextLine();
                        System.out.print("Enter the Departure Airport: ");
                        String Departure = input.nextLine();
                        System.out.print("Enter the Arrival Airport: ");
                        String Arrival = input.nextLine();
                        System.out.print("Enter flight of destination: ");
                        String destination = input.nextLine();

                        //read and validate date(year, month and day)
                        System.out.println("Enter flight date:");
                        System.out.print("year: ");
                        int year = input.nextInt();
                        if (year < 2024) {
                            System.out.println("Invalid year.");
                            continue;
                        }
                        System.out.print("month: ");
                        int month = input.nextInt();
                        if (month < 1 || month > 12) {
                            System.out.println("Invalid month.");
                            continue;
                        }
                        System.out.print("day: ");
                        int day = input.nextInt();
                        if (day < 1 || day > 31) {
                            System.out.println("Invalid day.");
                            continue;
                        }

                        // flight basePrice
                        System.out.print("Where do you want to sit? ");
                        int seat = input.nextInt();
                        if (seat < 0) {
                            System.out.println("Invalid seats.");
                            continue;
                        }

                        System.out.print("Enter base price:");
                        double price = input.nextDouble();
                        if (price < 0) {
                            System.out.println("Invalid price.");
                            continue;
                        }

                        //if or switch
                        if (FlightType == 1) {

                            System.out.print("is snack available on this flight?");
                            boolean snack = input.nextBoolean();
                            flight = new Economy(flightNum, Departure, Arrival, destination, new DATE(year, month, day), seat, price,snack);
                        } else if (FlightType == 2) {
                            System.out.print("is there any comfort Service?");
                            boolean comfort = input.nextBoolean();
                            flight = new Business(flightNum, Departure, Arrival, destination, new DATE(year, month, day), seat, price,comfort);
                        } else if (FlightType == 3) {
                            System.out.print(" what kind airline you want? (KSA or UAE)");
                            String airLine = input.nextLine();
                            flight = new FirstClass(flightNum, Departure, Arrival, destination, new DATE(year, month, day), seat, price,airLine);

                        }
                        flightList.add(flight);
                        System.out.println("Flight has been added to the list.");
                        //end else
                        break;

                        //Remove Flight
                    case 2:
                        System.out.print("Enter flight number to remove: ");
                        String flight_Num = input.next();
                        boolean removed = false;
                        for (int i = 0; i < flightList.size(); i++) {
                            Flight f = flightList.get(i);
                            if (f.getFLIGHT_NUM().equalsIgnoreCase(flight_Num)) {
                                flightList.remove(i);
                                removed = true;
                                break;
                            }
                        }

                        if (removed) {
                            System.out.println("Flight with number " + flight_Num + " has been removed.");
                        } else {
                            System.out.println("No flight with number " + flight_Num + " is found.");
                        }
                        break;

                        //Display Flights
                    case 3:

                        for (Flight f : flightList) {
                            System.out.println("Flight Type: " + f.getClass().getSimpleName());// print class name poly
                            System.out.println(f); // toString
                            System.out.println("Available: " + f.isAvailable());

                           // Polymorphic methods(Polymorphism)
                            System.out.printf("Total Flight Cost: %.2f SAR.\n", f.calculateprice());

                            // Downcasting to call specific methods
                            if (f instanceof FirstClass) {
                                System.out.println("what is your AirLine? ");
                                System.out.println(((FirstClass) f).calculateFirstDuration());
                            }
                            System.out.println("---------------------------------");
                        }
                        System.out.println("Flight Count: " + Flight.getTotalFlights());

                        break;

                      //New Booking
                    case 4:
                        System.out.print("Enter Flight number: ");
                        flightNum = input.next();
                       //search for flight

                        for (Flight f : flightList) {

                            if (f.getFLIGHT_NUM().equalsIgnoreCase(flightNum)) {
                                if (f.isAvailable()) {
                                    flight = f;
                                    break;
                                }
                            }
                        }//end loop
                        if (flight == null) {
                            System.out.println("Invalid flight number or no seats available.");
                            continue;
                        }
                        System.out.print("How many passengers are traveling? (Max is 10 persons) : ");
                        int passengersNum = input.nextInt();
                        if (passengersNum < 1 || passengersNum > Bookable.MAX_BOOKING_PERSON) {
                            System.out.println("invalid passengers number.");
                            continue;
                        }

                         //create and fill the array of passengers
                        Passenger[] passengerArray = new Passenger[passengersNum];
                        for (int i = 0; i < passengerArray.length; i++) {

                             //read passenger info
                            System.out.printf("Enter passenger #%d id: ", (i + 1));
                            int passengerId = input.nextInt();

                            System.out.printf("Enter passenger #%d passport number: ", (i + 1));
                            String passengerPassportNum = input.next();

                            System.out.printf("Enter passenger #%d first and last name: ", (i + 1));
                            input.nextLine();
                            String passengerName = input.nextLine();

                           //create object
                            Passenger p = new Passenger(passengerId, passengerPassportNum, passengerName);
                            passengerArray[i] = p;
                        }

                        //Taxi booking
                        Taxi bookingTaxi;
                        //Available Taxi
                        Taxi T1 = new Taxi(445008739, "Mohamed", 100.0, true, "Big car");
                        System.out.print("Would you like to book Taxi car ? " + T1.getName() + "? (Y/N): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            bookingTaxi = T1;
                            System.out.println("Taxi is booked for you.");
                        } else {
                            bookingTaxi = null;
                            System.out.println("No Taxi is booked.");
                        }

                       //create booking object
                        b = new Booking(flight, bookingTaxi, passengerArray);
                       //confirm
                        System.out.print("Confirm order? (Yes /No): ");
                        answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            b.confirm();
                            System.out.println(b);
                        } else {
                            System.out.println("Your booking has been cancelled!");
                        }
                        break;

                       //Display Booking
                    case 5:
                        if (b != null) {
                            System.out.print(b);
                        } else {
                            System.out.println("No Booking");
                        }

                        break;

                    //Cancel Booking
                    case 6:
                        if (b != null) {
                            b.cancel();
                        }
                        break;

                     //GUI
                    case 7:

                        GUI.main(null);


                        break;

                    //Read from text file
                    case 8:
                        ReadText rt = new ReadText();
                        rt.openTextFile("flights.txt");
                        rt.readFromFile();
                        rt.closeFile();

                        break;

                    case 9:

                        WriteText wf = new WriteText();
                        wf.openTextFile("flights.txt");
                        if (flightList.isEmpty()) {
                            System.out.println("No flights yet.");
                        } else {
                            for (Flight fli : flightList) {
                                wf.writeToFile(fli);
                            }
                        }
                        wf.closeFile();
                        System.out.println("All flights saved to the text file flights.txt");
                        break;

                    case 10:
                        System.out.println("Thank you for using our system.\nHave a nice day.");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                   //end switch
                }

            } catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                input.nextLine();
            }
            catch(Exception e){
                System.out.println("Error: "+ e);
            }
        } while (choice != 10);
    }

    public static void menu() {
        System.out.println("\n"
                + "1. Add Flight.\n"
                + "2. Remove Flight.\n"
                + "3. Display Flights\n"
                + "4. New Booking\n"
                + "5. Display Booking\n"
                + "6. Cancel Booking\n"
                + "7. GUI\n"
                + "8. Read From File\n"
                + "9. Save Orders.\n"
                + "10.Exit>> ");
    }

    public static void Listexample(ArrayList<Flight> list) {

        Flight f1 = new Economy("S476", "6:59 AM", "10:00 AM", "Dammam", new DATE(2024, 5, 22), 100, 300,true);
        Flight f2 = new Business("F102", "9:00 PM", "10:45PM", "DUBAI", new DATE(2024, 4, 10), 100, 400,false);
        Flight f3 = new FirstClass("SF100", "12:00 PM", "5:00PM", "UK", new DATE(2024, 12, 20), 100, 500,"KSA");

        list.add(f1);
        list.add(f2);
        list.add(f3);
    }
}
