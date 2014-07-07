package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;

public class Airline {
    Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    public Airline() {
        super();
    }
    public String getName() {
        return name;
    }
    private String name;
}
