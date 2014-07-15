package edu.pdx.cs410J.lilak;


import edu.pdx.cs410J.AbstractFlight;
import java.lang.StringBuilder;

/** Flight class implements details of an airline flight*/
public class Flight extends AbstractFlight {
    Class c = AbstractFlight.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    /** Constructor default */
    public Flight() {
        super();
    }


    /** Alternative constructor which takes in flight information
     *
     * @param flightnumber  integer value of flight number
     * @param origin    3 letter origin code
     * @param depart_timedate time/date string of departure
     * @param destination 3 letter destination code
     * @param arrive_timedate time/date string of arrival
     */
    public Flight(int flightnumber, String origin, String depart_timedate, String destination, String arrive_timedate) {
        super();
        depart_time_date=depart_timedate;
        arrive_time_date=arrive_timedate;
        origin_code=origin;
        destination_code=destination;
        flight_number=flightnumber;
    }

    /**printflight() method prints out the details of the flight */
    public void PrintFlight() {
        System.out.print("Flight number "+ flight_number + " departs from " +
                origin_code + " at "+ depart_time_date + " and arrives at " +
                destination_code + " at " + arrive_time_date + "\n");
    }

    public String GetFlightString() {
        StringBuilder sb= new StringBuilder("");
        sb.append(flight_number).append(" ").append(origin_code).append(" ").append(depart_time_date).append(" ");
        sb.append(destination_code).append(" ").append(arrive_time_date).append("\n");
        return sb.toString();
    }

    /** getNumber() returns the integer flight number */
    public int getNumber() {
        return flight_number;
    }

    /**getsource() returns the 3 character origin city code */
    public java.lang.String getSource() {
        return origin_code;
    }

    /** getdeparturestring() returns the time/date departure string */
    public java.lang.String getDepartureString() {
        return depart_time_date;
    }

    /**getdestination() returns the string 3 character code for destination */
    public java.lang.String getDestination() {
        return destination_code;
    }

    /**getarrivalstring() returns the time/date of the arrival */
    public java.lang.String getArrivalString() {
        return arrive_time_date;
    }


    /** depart_time_date is the string for departure information */
    private String depart_time_date;
    /** arrive_time_date is the string for arrival information */
    private String arrive_time_date;
    /** origin_code is the 3 character origin code */
    private String origin_code;
    /** destination_code is the 3 character destination code */
    private String destination_code;
    /** flight_number is the integer flight number */
    private int flight_number;
}
