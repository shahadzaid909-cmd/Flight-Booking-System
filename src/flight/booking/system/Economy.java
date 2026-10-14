
package flight.booking.system;

public class Economy extends Flight {


private boolean SnackeAvailable;

// constructor
public Economy( String FLIGHT_NUM, String DepartureAirport, String ArrivalAirport, String destination, DATE date, int Seat, double price,boolean SnackeAvailable) {
super(FLIGHT_NUM, DepartureAirport, ArrivalAirport,destination, date, Seat, price);
this.SnackeAvailable=SnackeAvailable;
}

public Economy() {
this("", "", "",  "", null, 0, 0.0,false);
}



    public boolean isSnackeAvailable() {
        return SnackeAvailable;
    }

    public void setSnackeAvailable(boolean SnackeAvailable) {
        this.SnackeAvailable = SnackeAvailable;
    }






// methods :

@Override
public double calculateprice(){
double cost = getPrice();

if(SnackeAvailable){
cost+=50;
}
return cost;
}

@Override
public String toString() {
return String.format(" %s\njuice Available: %s " , super.toString(),SnackeAvailable);
}



}

