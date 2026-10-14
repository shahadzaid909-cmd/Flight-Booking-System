package flight.booking.system;

public class Business extends Flight{
private boolean comfortServiceas;


// constructor

public Business(String FLIGHT_NUM, String DepartureAirport, String ArrivalAirport,String destination, DATE date, int Seat, double price,boolean comfortServiceas) {
super(FLIGHT_NUM, DepartureAirport, ArrivalAirport,destination, date, Seat, price);
this.comfortServiceas=comfortServiceas;

}

public Business() {
this("", "", "", "", null, 0, 0.0,false);

}

    Business(String flightNum, String Departure, String Arrival, String destination, DATE date, int seat, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isComfortServiceas() {
        return comfortServiceas;
    }

    public void setComfortServiceas(boolean comfortServiceas) {
        this.comfortServiceas = comfortServiceas;
    }



// methods :

@Override
public double calculateprice(){

    double cost =getPrice();
     if(comfortServiceas){
     cost+=400;
     
     }

return cost;

}






@Override
public String toString() {
return String.format(" %s\ncomfort Serviceas  : %s " , super.toString(),comfortServiceas );

}






}