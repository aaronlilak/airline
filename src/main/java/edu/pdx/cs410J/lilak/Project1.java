package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;


/**
 * The main class for the CS410J airline Project
 */

public class Project1 {

    //validate if an input parameter is valid....
    public static boolean validate_input_param(String thisarg, int index) {
        //System.out.print("calling input validation on index of "+ index + " and arg of " + thisarg + "\n");
        switch (index) {
            case 0:
                //just needs to be a String
                return true;
                //break;
            case 1:
                //flight number...needs to be integer
                if (thisarg.matches("\\d+")) {
                    //have a positive integer now..
                    return true;
                } else {
                    System.out.print("Flight number " + thisarg + " is not a positive integer \n");
                }
                break;
            case 2:
            case 5:
                //three letter depart code
                if (thisarg.length()!=3) {
                    System.out.print("Origin/Destination code is not three letters \n");
                    break;
                }
                if (!thisarg.matches("[a-zA-Z]+")) {
                    System.out.print("Origin/Destination code must be letters only \n");
                    break;
                }
                return true;
                //break;
            case 3:
            case 6:
                if (!thisarg.matches("\\d+/\\d+/\\d+")) {
                    System.out.print("Date not formatted correctly....should be m/d/year \n");
                    break;
                }

                String [] tokensdate = thisarg.split("/");
                if (Integer.parseInt(tokensdate[0])>12) {
                    System.out.print("Month must be in range of 0-12 \n");
                    break;
                }

                if (Integer.parseInt(tokensdate[1])>31) {
                    System.out.print("Day must be in range of 0-31 \n");
                    break;
                }

                if (Integer.parseInt(tokensdate[2])<1903) {
                    System.out.print("Year must be >1903 when Wright Brothers First Flew \n");
                    break;
                }
                //depart date
                return true;
                //break;
            case 4:
            case 7:
                if (!thisarg.matches("\\d+:\\d+")) {
                    System.out.print("Time not formatted correctly....should be hh:mm \n");
                }

                String [] tokens = thisarg.split(":");
                if (Integer.parseInt(tokens[0])>24) {
                    System.out.print("Hour can not be greater than 24 \n");
                    break;
                }
                if (Integer.parseInt(tokens[1])>60) {
                    System.out.print("Minute can not be greater than 60 \n");
                    break;
                }
                if ((Integer.parseInt(tokens[0])==24) && (Integer.parseInt(tokens[1])!=0)) {
                    System.out.print("Time must be less than 24:00 \n");
                    break;
                }

                //depart time
                return true;
        }
        return false;
    }

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
        int argcount = 0;
        boolean printit = false;
        String [] plist = new String[8];
        for (String arg : args) {
            //System.out.println(arg);
            if (arg.contentEquals("-README")) {
                printreadme();
                System.exit(0);
            }
            if (arg.contentEquals("-print")) {
                printit = true;
                continue;
            }
            //if you got here you should validate the input now
            boolean goodinput = validate_input_param(arg, argcount);
            if (goodinput==false) {
                System.err.print("Problem with input stream");
                System.exit(1);
            }
            plist[argcount]=arg;
            argcount++;
        }

        if (argcount < 8) {
            //expect 8 command line args for a complete flight input
            System.err.println("Missing some command line arguments....require 8 arguments to initiate. Review the \"-README\" option");
            System.exit(1);
        }

        Airline thisairline=new Airline(plist[0]);
        if (printit) thisairline.PrintAirline();
        Flight thisflight=new Flight(Integer.parseInt(plist[1]), plist[2], plist[3]+" "+plist[4], plist[5], plist[6]+" "+plist[7]);
        if (printit) thisflight.PrintFlight();

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

