package edu.pdx.cs410J.lilak;


import edu.pdx.cs410J.AbstractFlight;

public class Flight extends AbstractFlight {
    Class c = AbstractFlight.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    public Flight() {
        super();
    }

    public Flight(String depart_timedate, String arrive_timedate, String origin, String destination, int flightnumber) {
        super();
        depart_time_date=depart_timedate;
        arrive_time_date=arrive_timedate;
        origin_code=origin;
        destination_code=destination;
        flight_number=flightnumber;
    }

    public void PrintFlight() {
        System.out.print("Flight number "+ flight_number + " departs from " +
                origin_code + " at "+ depart_time_date + " and arrives at " +
                destination_code + " at " + arrive_time_date );
    }

    public int getNumber() {
        return flight_number;
    }

    public java.lang.String getSource() {
        return origin_code;
    }

    public java.lang.String getDepartureString() {
        return depart_time_date;
    }

    public java.lang.String getDestination() {
        return destination_code;
    }

    public java.lang.String getArrivalString() {
        return arrive_time_date;
    }


    private String depart_time_date;
    private String arrive_time_date;
    private String origin_code;
    private String destination_code;
    private int flight_number;
}
