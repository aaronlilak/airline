package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;

/** Airline class is implementation of Airline. In project1 airline is given a name */
public class Airline extends AbstractAirline {
    Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    /**Constructor */
    public Airline() {
        super();
    }

    /**Constructor which takes a String argument for the name
    * @param thisname is name of airline
    */

     public Airline(String thisname) {
        super();
        name=thisname;
    }

    /**PrintAirline prints out the airline name
     */
    public void PrintAirline() {
        System.out.print("Airline is named " + name + "\n");
        return;
    }

    /**getName returns the name of the airline */
    public String getName() {
        return name;
    }

    /**addFlight adds in a flight the flight collection */
    public void addFlight(edu.pdx.cs410J.AbstractFlight abstractFlight) {
        return;
    }

    /**getFlights() will return the list of flights in future */
    public java.util.Collection getFlights() {
        return null;
    }

    /**setName sets the name of the airline */
    public void setName(String namestring) {
        name=namestring;
    }

    //An airline has a name and contains a list of flights
    /**name is a String with name of the airline */
    private String name;
    /**flightlist is an array of flights */
    private Flight[] flightlist;
}
