package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.lilak.Flight;
import edu.pdx.cs410J.lilak.Airline;
import edu.pdx.cs410J.AirlineDumper;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Iterator;

/** The TextDumper class implements AirlineDumper*/
/** TextDumper will write to a file the contents of an airline*/
public class TextDumper implements AirlineDumper {
    /**constructor with no arguments*/
    public TextDumper() {
        return;
    }
    /**constructor taking in a string for the filename to be created*/
    public TextDumper(String fname) {
        filename=fname;
    }

    /**write method to be called from dump....this does the work */
    /**takes in an Airline to be written */
    public void writeitout( Airline thisairline) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename), "utf-8"));
            Iterator itr=thisairline.flightlist.iterator();
            while (itr.hasNext()) {
                Flight thisone=(Flight)itr.next();
                String flightstring=thisone.GetFlightString();
                writer.write(thisairline.getName() + " " +flightstring + "\r\n");
            }
            //writer.write("Something");
        } catch (Exception ex) {
            System.out.print("There was a problem writing to the file "+ filename);
            System.exit(1);
        }
        finally {
            try {writer.close();} catch (Exception ex) {}
        }
    }

    /**dump method for abstractairline implementation */
    public void dump (AbstractAirline thisairline) {
        return;
    }

    /**implementaiton of dump method for airline class*/
    public void dump (Airline thisairline) {
        writeitout(thisairline);
        return;
    }

    /**setfilename will let you set the filename the dumper will create/write to*/
    public void setfilename(String file) {
        filename=file;
    }

    /**getfilename will return the string filename you are using in dump*/
    public String getFilename() {
        return filename;
    }

    /**filename string contains the String filename you are working with in TextDump (where you write to) */
    private String filename;

}
