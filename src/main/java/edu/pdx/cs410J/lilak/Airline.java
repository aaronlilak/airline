package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;

public class Airline extends AbstractAirline {
    Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    public Airline() {
        super();
    }

    public Airline(String thisname) {
        super();
        name=thisname;
    }

    public void PrintAirline() {
        System.out.print("Airline is named " + name + "\n");
        return;
    }

    public String getName() {
        return name;
    }

    public void addFlight(edu.pdx.cs410J.AbstractFlight abstractFlight) {
        return;
    }

    public java.util.Collection getFlights() {
        return null;
    }

    public void setName(String namestring) {
        name=namestring;
    }

    //An airline has a name and contains a list of flights
    private String name;
    private Flight[] flightlist;
}
