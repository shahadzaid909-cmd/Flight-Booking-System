
package flight.booking.system;



public class Booking {

private final int ID;
private Flight flight;
private Taxi taxi;
private Passenger passengers[];
private String status;


// constructor

public Booking( Flight flight, Taxi taxi, Passenger[] passengers) {
this.ID = generatedId();
this.flight = flight;
this.taxi = taxi;
this.passengers = passengers;
this.status = "new";
}

public Booking() {

this(null , null , null);
}




// Getters and Setters

public int getID() {
return ID;
}

public Flight getFlight() {
return flight;
}

public void setFlight(Flight flight) {
this.flight = flight;
}

public Taxi getTaxi() {
return taxi;
}

public void setTaxi(Taxi taxi) {
this.taxi = taxi;
}

public Passenger[] getPassengers() {
return passengers;
}

public void setPassengers(Passenger[] passengers) {
this.passengers = passengers;
}


public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

// methods :


private final double calculateTotal(){

double flightprice = flight.getPrice();
flightprice = flightprice * passengers.length;

double taxiprice = 0 ;
if (taxi != null ){
taxiprice = taxi.getPrice();
}
double total= flightprice + taxiprice;

//VAT 15%
total += (total * Bookable.VAT);
return total;
}

public final void confirm(){
setStatus("Confirmed");
flight.book();
System.out.println("Your booking has been confirmed. Thanks");
}

public final void cancel(){
setStatus("Cancelled");
flight.cancelBooking();
System.out.println("Your booking has been cancelled. Thanks");
}

@Override
public String toString() {
return "Booking{\n" + " flight=" + flight + "\n taxi=" + taxi + "\npassenger=" + passengers +  "\nstatus=" + status + '}';
}


private final int generatedId(){
int min = 1;
int max = 1000;
int id = (int)(Math.random())* ((max - min) + 1) + min;
return id;
}

//public String passengers(){
// String s = "";
// for (Passenger p = passengers) {
// s += p + "\n -------------------------------------\n";
// }
// return s;
//
//}





}
