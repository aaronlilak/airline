package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;

/**
 * The main class for the CS410J airline Project. This class wraps invocation and the parser functionality
 */

public class Project3 {


    //validate if an input parameter is valid....

    /** validate_input_param is function which takes in
     *
     * @param thisarg   String value of the argument
     * @param index index in the input stream in which it arrived exclusive of options
     * @return a boolean value if the input is in a valid format. This is determined dependent upon the argument. F
     * For instance the date must be in mm/dd/yy format, time in military format must have hour <25, etc..
     */
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
            case 6:
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
            case 7:
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
            case 8:
                if (!thisarg.matches("\\d+:\\d+")) {
                    System.out.print("Time not formatted correctly....should be hh:mm \n");
                    break;
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
                return true;
            case 5:
            case 9:
                if (!thisarg.contentEquals("AM") && (!thisarg.contentEquals("PM") && (!thisarg.contentEquals("am")) && (!thisarg.contentEquals("pm")))) {
                    System.out.print("Expect an AM or a PM on the time argument \n");
                    System.out.print("Invalid input for argument " + thisarg + "\n");
                    break;
                }
                //depart time
                return true;
        }
        return false;
    }

    public static String Readme_Message = "Program written by Aaron Lilak. This is implementation of CS410J program3. It allows for input of an" +
            " airline and flight information. This program will be built upon in future projects. \n" +
            "usage: java edu.pdx.cs410J.lilak.Project3 [options] <args>\n" +
            "args are (in this order):\n" +
            "name The name of the airline\n" +
            "flightNumber The flight number\n" +
            "src Three-letter code of departure airport\n" +
            "departTime Departure date and time (12-hour time)\n" +
            "dest Three-letter code of arrival airport\n" +
            "arriveTime Arrival date and time (12-hour time)\n" +
            "options are (options may appear in any order):\n" +
            "-print Prints a description of the new flight\n" +
            "-README Prints a README for this project and exits\n" +
            "-textFile filename reads/writes to the given file for initialization of an airline \n"+
            "-pretty filename writes to a user-readable file in a nice-to-read format"+
            "Date and time should be in the format: mm/dd/yyyy hh:mm am/pm";


    /** main invocation which takes in args from user */

    public static void main(String[] args) {
        //System.out.print("p3 main \n");
        Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
        int argcount = 0;
        String filename=null;
        String prettyfilename=null;
        boolean printit = false;
        String [] plist = new String[10];
        plist[0]="Default Airline Name";
        Boolean setfilenamenext=false;
        Boolean setprettynext=false;
        Boolean havesomepartofflight=false;
        for (String arg : args) {
            if (setfilenamenext==true) {
                setfilenamenext=false;
                filename=arg;
                continue;
            }
            if (setprettynext==true) {
                setprettynext=false;
                prettyfilename=arg;
                continue;
            }
            //System.out.println(arg);
            if (arg.contentEquals("-README")) {
                printreadme();
                System.exit(0);
            }
            if (arg.contentEquals("-print")) {
                printit = true;
                continue;
            }
            if (arg.contentEquals("-textFile")) {
                setfilenamenext=true;
                continue;
            }
            if (arg.contentEquals("-pretty")) {
                setprettynext=true;
                continue;
            }

            //if you got here you should validate the input now
            boolean goodinput = validate_input_param(arg, argcount);
            if (goodinput==false) {
                System.err.print("Problem with input stream for arg "+ arg);
                System.exit(1);
            }
            plist[argcount]=arg;
            if (argcount>0) havesomepartofflight=true;
            argcount++;
        }
        if (setfilenamenext==true) {
            System.out.print("Problem specifying the filename \n");
            System.exit(1);
        }
        if (setprettynext==true) {
            System.out.print("Problem specifying the filename for -pretty option \n");
            System.exit(1);
        }

        if ((filename==null) || (havesomepartofflight==true)) {
            if (argcount < 10) {
                //expect 10 command line args for a complete flight input
                System.err.println("Missing some command line arguments....require 10 arguments to initiate. Review the \"-README\" option");
                System.exit(1);
            }
        }

        Airline ap2=new Airline();

        //now read in the file....need to compare airline name here
        if (filename != null) {
            TextParser tp2 = new TextParser(filename);
            try {
                ap2=tp2.parse();
            } catch(Exception ex) {
                System.out.print("Exception thrown in the parser");
                System.exit(1);
            }
        }
        if (ap2.getSize()==0) {
            ap2.setName(plist[0]);
        } else {
            if (!plist[0].contentEquals(ap2.getName())) {
                System.out.print("Mismatch in the airline names between the commandline and the file "+ filename + " " + ap2.getName() + " vs " + plist[0]+ "\n");
                System.exit(1);
            }
        }

        if (havesomepartofflight==true) {
            Flight thisflight=new Flight(Integer.parseInt(plist[1]), plist[2], plist[3]+" "+plist[4] + " " +plist[5], plist[6], plist[7]+" "+plist[8]+" "+plist[9]);
            ap2.addFlight(thisflight);
        }
        /*
        Airline airlinetest=new Airline();
        try {
            airlinetest = tp2.parse();
        } catch (edu.pdx.cs410J.ParserException pe) {
            System.out.print("Problem with the parsing of the file " + filename);
            System.exit(1);
        }
        */
        //
        //thisairline.addRealFlight(thisflight);

        if (filename != null) {
            TextDumper td2=new TextDumper(filename);
            td2.dump(ap2);
        }
        if (prettyfilename !=null) {
            TextDumper td2=new TextDumper(prettyfilename);
            td2.prettydump(ap2);

        }
        if (printit) {
            ap2.PrintAirline();
        }

        System.exit(0);
    }



    /**printreadme() is method to print out the readme text */
    public static void printreadme() {
        System.out.println(Readme_Message);
        return;
    }

    /** printairline() will print out the airline information */
    public static void printairline() {
        return;
    }
}

