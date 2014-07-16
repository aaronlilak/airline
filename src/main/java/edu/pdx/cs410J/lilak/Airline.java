package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;
import java.util.Collections;

import edu.pdx.cs410J.AbstractFlight;
import edu.pdx.cs410J.lilak.Flight;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/** Airline class is implementation of Airline. In project1 airline is given a name */
public class Airline extends AbstractAirline {
    Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath

    /**Constructor */
    public Airline() {
        super();
        sizefl=0;
    }

    /**Constructor which takes a String argument for the name
    * @param thisname is name of airline
    */

     public Airline(String thisname) {
        super();
        List flightlist = new ArrayList();
        name=thisname;
         sizefl=0;
    }

    /**PrintAirline prints out the airline name
     */
    public void PrintAirline() {
        System.out.println("Airline is named " + name + "\n");
        for (Iterator it=flightlist.iterator(); it.hasNext();) {
            //it.next();
            Object thisone=it.next();
            Flight temp=(Flight) thisone;
            temp.PrintFlight();
        }
        return;
    }

    /**getName returns the name of the airline */
    public String getName() {
        return name;
    }

    public Integer getSize() { return sizefl; }



    /**addFlight adds in a flight the flight collection */

    public void addFlight(AbstractFlight newFlight) {
        flightlist.add(newFlight);
        sizefl=flightlist.size();
        return;
    }

    public void addRealFlight(Flight newFlight) {
        flightlist.add(newFlight);
        sizefl=flightlist.size();
        System.out.print("flightlist is of length " + flightlist.size() + " now \n");
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
    /**flightlist is a list of flights */

    private Integer sizefl;

    public List<AbstractFlight> flightlist = new ArrayList<AbstractFlight>();


}
