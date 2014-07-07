package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;


/**
 * The main class for the CS410J airline Project
 */

public class Project1 {

    public static String Readme_Message = "usage: java edu.pdx.cs410J.lilak.Project1 [options] <args>\n" +
            "args are (in this order):\n" +
            "name The name of the airline\n" +
            "flightNumber The flight number\n" +
            "src Three-letter code of departure airport\n" +
            "departTime Departure date and time (24-hour time)\n" +
            "dest Three-letter code of arrival airport\n" +
            "arriveTime Arrival date and time (24-hour time)\n" +
            "options are (options may appear in any order):\n" +
            "-print Prints a description of the new flight\n" +
            "-README Prints a README for this project and exits\n" +
            "Date and time should be in the format: mm/dd/yyyy hh:mm";

    public static void main(String[] args) {
    Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    int argcount=0;
    boolean printit=false;
    for (String arg : args) {
      System.out.println(arg);
      if (arg.contentEquals("-README")) {
        printreadme();
        System.exit(0);
      }
      if (arg.contentEquals("-print")) {
          printit=true;
          continue;
      }
      argcount++;
    }
    if (printit==true){
        printairline();
    }
    if (argcount<6) {
       //expect 6 command line args for a complete flight input
       System.err.println("Missing some command line arguments....require 6 arguments to initiate. Review the \"-README\" option");
       System.exit(1);
    }
    System.exit(0);
  }

    public static void printreadme() {
        System.out.println(Readme_Message);
        return;
    }

    public static void printairline() {
        return;
    }

}