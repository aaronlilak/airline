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
import java.util.Iterator;

public class TextDumper implements AirlineDumper {
    public TextDumper() {
        return;
    }
    public TextDumper(String fname) {
        filename=fname;
    }

    public void writeitout( Airline thisairline) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename), "utf-8"));
            Iterator itr=thisairline.flightlist.iterator();
            while (itr.hasNext()) {
                Flight thisone=(Flight)itr.next();
                String flightstring=thisone.GetFlightString();
                writer.write(thisairline.getName() + " " +flightstring);
            }
            //writer.write("Something");
        } catch (IOException ex) {
            System.out.print("Problem with opening/writing to the file");
            System.exit(1);
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }
    }

    public void dump (AbstractAirline thisairline) {
        return;
    }

    public void dump (Airline thisairline) {
        writeitout(thisairline);
        return;
    }

    public void setfilename(String file) {
        filename=file;
    }

    public String getFilename() {
        return filename;
    }

    private String filename;

}
