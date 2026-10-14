

package flight.booking.system;


public class FirstClass extends Flight {

private String AirLine;

// Constructor

    public FirstClass(String FLIGHT_NUM, String DepartureAirport, String ArrivalAirport, String destination, DATE date, int Seat, double price,String AirLine) {
        super(FLIGHT_NUM, DepartureAirport, ArrivalAirport, destination, date, Seat, price);
        this.AirLine = AirLine;
    }




public FirstClass(){
this("", "", "", "", null, 0, 0.0,"");

}


    public String getAirLine() {
        return AirLine;
    }

    public void setAirLine(String AirLine) {
        this.AirLine = AirLine;
    }





// methods:

@Override
public double calculateprice(){

return 500;

}


public int calculateFirstDuration(){
 
    switch (AirLine){
        case "KSA":
  return 3;
        case "UAE":
    return 4;
     
        default :
            return 0;
    }
    
    



}



@Override
public String toString() {
return String.format("%s\nAirLine: %s " , super.toString(),AirLine);

}


}






