package flight.booking.system;

public abstract class Flight implements Bookable {

    private final String FLIGHT_NUM;
    private String DepartureAirport;
    private String ArrivalAirport;
    private String destination;
    private DATE date;
    int Seat;
    private double price; // base cost
    private static int totalFlights;

// constructor
    public Flight(String FLIGHT_NUM, String DepartureAirport, String ArrivalAirport, String destination, DATE date, int Seat, double price) {
        this.FLIGHT_NUM = FLIGHT_NUM;
        this.DepartureAirport = DepartureAirport;
        this.ArrivalAirport = ArrivalAirport;
        this.destination = destination;
        this.date = date;
        this.Seat = Seat;
        this.price = price;
        totalFlights++;

    }

    public Flight() {
        this("", "", "", "", null, 0, 0.0);

    }

// methods :
// force child classes to implements :
    public abstract double calculateprice();

// interface methods :
    @Override
    public final boolean isAvailable() {
        if (Seat > 0 && Seat >= 150) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public final void book() {
        Seat--;
        System.out.println("seat is booked on this flight");
        System.out.println("Remaining seat: " + getSeat());

    }

    @Override
    public final void cancelBooking() {
        Seat++;
        System.out.println("Seat booking is cancelled and now is available.");
        System.out.println("Available seats: " + getSeat());

    }

// Getters and Setters
    public String getFLIGHT_NUM() {
        return FLIGHT_NUM;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(String DepartureAirport) {
        this.DepartureAirport = DepartureAirport;
    }

    public String getArrivalAirport() {
        return ArrivalAirport;
    }

    public void setArrivalAirport(String ArrivalAirport) {
        this.ArrivalAirport = ArrivalAirport;
    }

    public DATE getDate() {
        return date;
    }

    public void setDate(DATE date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeat() {
        return Seat;
    }

    public void setSeat(int Seat) {
        if (Seat < 0 && Seat > 150) {
            System.out.println("Invalied seat");
        } else {
            this.Seat = Seat;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 300) {
            System.out.println("Invalied price");
        } else {
            this.price = price;
        }
    }

    public static int getTotalFlights() {
        return totalFlights;
    }

    public static void setTotalFlights(int totalFlights) {
        Flight.totalFlights = totalFlights;
    }

    @Override
    public String toString() {
        return String.format("Flight Number: %s\nDeparture Airport: %s\nArrival Airport: %s \nDATE: %s\nDestination: %s\nAvailable Seat: %d\nPrice: %.2f SAR",
                getFLIGHT_NUM(), getDepartureAirport(), getArrivalAirport(), getDate(), getDestination(), getSeat(), getPrice());
    }
}
