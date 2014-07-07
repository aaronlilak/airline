package edu.pdx.cs410J.lilak;


import edu.pdx.cs410J.AbstractFlight;

public class Flight {
    Class c = AbstractFlight.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    public Flight() {
        super();
    }
    private String depart_time_date;
    private String arrive_time_date;
    private String origin_code;
    private String departure_code;
    private String flight_number;
}
