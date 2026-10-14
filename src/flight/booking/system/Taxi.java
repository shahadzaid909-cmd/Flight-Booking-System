
package flight.booking.system;

public class Taxi implements Bookable {

private final int ID;
private String name;
private double price;
private boolean available;
private String carType;

// constructor

public Taxi(int ID, String name, double price, boolean available, String carType) {
this.ID = ID;
this.name = name;
this.price = price;
this.available = available;
this.carType = carType;
}

public Taxi() {
this (0 , "" , 0.0, true , "");
}


// methods :

@Override
public boolean isAvailable() {
if (available){
return true;
} else {
return false ;
}


}

@Override
public void book() {
available = false;
System.out.println("Taxi car is been booked for you");

}

@Override
public void cancelBooking() {
available = false;
System.out.println("Taxi car booking is cancelled");

}

// Getters and Setters

public int getID() {
return ID;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
if (price <= 0){
System.out.println("Invalied price");
} else {
this.price = price; }
}

public String getCarType() {
return carType;
}

public void setCarType(String carType) {
this.carType = carType;
}

@Override
public String toString(){
return String.format("ID: %d\nName: %S\nprice: %.2f SAR\nCar Type: %s",getID(), getName(),getPrice() ,getCarType());



}

}