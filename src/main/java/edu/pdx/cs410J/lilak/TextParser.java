package edu.pdx.cs410J.lilak;
import edu.pdx.cs410J.AirlineParser;
import edu.pdx.cs410J.lilak.Airline;

public class TextParser implements AirlineParser {
    TextParser (String thisfilename) {
        filename=thisfilename;
    }
    public Airline parse() {
        //case 1: file already exists and no command line. Create and read in airline and exit.
        //case 2: file already exists and command line. Create and read in airline. Add in new flight to file and exit.
        //case 3: file doesn't exist and no command line. There is nothing to do here. exit.
        //case 4: file doesn't exist and command line. Create airline, add new flight to file and exit
        return null;
    }
    private String filename;
}
