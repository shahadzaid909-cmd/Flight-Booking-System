package flight.booking.system;


public interface Bookable {


public static final int MAX_BOOKING_PERSON = 10;
public static final double VAT = 0.15;


public abstract boolean isAvailable();

public abstract void book();

public abstract void cancelBooking();

}

