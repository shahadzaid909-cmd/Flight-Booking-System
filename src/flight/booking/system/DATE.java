
package flight.booking.system;



public final class DATE {
private int day;
private int month;
private int year;

public DATE(int day, int month, int year) {
this.day = day;
this.month = month;
this.year = year;
}

    public DATE() {
        this(0,0,0);
    }




@Override
public String toString() {
return day + "/" + month + "/" + year;
}

}

