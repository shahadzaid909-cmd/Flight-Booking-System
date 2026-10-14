
package flight.booking.system;

class Passenger {
private final int ID;
private final String PASSPORT_NUM ;
private String name;



// counstructor

public Passenger(int ID,String PASSPORT_NUM, String name) {
this.ID = ID;
this.name = name;
this.PASSPORT_NUM=PASSPORT_NUM;
        
}

public Passenger() {
this(0 , "" ,"");
}



// Getters and Setters

public int getID() {
return ID;
}


public String getPASSPORT_NUM() {
return PASSPORT_NUM;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}


// methods :

@Override
public String toString() {
return "Passenger{" + "id=" + ID + ", passport_num=" + PASSPORT_NUM + ", name=" + name + '}';
}



}

