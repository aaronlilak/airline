package edu.pdx.cs410J.lilak;


import edu.pdx.cs410J.InvokeMainTestCase;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
public class Project1Test extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project1.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Ignore
  public void testNoCommandLineArgumentsError() {
    MainMethodResult result = invokeMain();
    assertEquals(new Integer(1), result.getExitCode());
  }

    @Ignore
  public void testFiveCommandLineArgumentsError() {
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX", "7/5/2014", "8:07", "PM" , "MDW");
    assertEquals(new Integer(1), result.getExitCode());
  }

    @Ignore
  public void testEightCommandLineArgumentsGood() {
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX",  "7/5/2014", "6:07", "PM", "MDW", "7/5/2014", "8:07", "PM");
    assertEquals(new Integer(0), result.getExitCode());
  }

    @Ignore
   public void testFiveCommandLineArgumentsWithReadme() {
     MainMethodResult result = invokeMain("-README","CS410Airline", "1503", "PDX", "7/5/2014", "8:07", "PM", "MDW");
     assertEquals(new Integer(0), result.getExitCode());
   }

  @Ignore
  public void testReadmeWithNoArgsIsOK() {
    MainMethodResult result = invokeMain("-README");
      assertEquals(new Integer(0), result.getExitCode());
  }

  @Ignore
  public void testReadmeWithSomeArgsIsOK() {
      MainMethodResult result = invokeMain("CS410Airline", "-README");
      assertEquals(new Integer(0), result.getExitCode());
  }

  @Ignore
    public void testFlightNumberIsNotInteger() {
      MainMethodResult result = invokeMain("CS410Airline", "notinteger");
      assertEquals(new Integer(1), result.getExitCode());
      //result = invokeMain("CS410Airline",  "9879");
      //assertEquals(new Integer(0), result.getExitCode());
       //result = invokeMain("CS410Airline",  "-9879");
       //assertEquals(new Integer(1), result.getExitCode());
     }

      @Ignore
        public void testFlightNumberIsReallyInteger() {
          MainMethodResult result = invokeMain("CS410Airline",  "9879", "PDX", "10/3/2014", "6:34", "PM", "SFO", "10/4/2014", "7:33", "PM");
         assertEquals(new Integer(0), result.getExitCode());
      }

      @Ignore
        public void testFlightNumberIsPositiveInteger() {
          MainMethodResult result = invokeMain("CS410Airline",  "-9879", "PDX", "10/3/2014", "6:34", "PM", "SFO", "10/3/2014", "7:34", "PM");
         assertEquals(new Integer(1), result.getExitCode());
      }
@Ignore
       public void testOriginIsFourLetters() {
         MainMethodResult result = invokeMain("CS410Airline",  "9879", "ABCD", "10/3/2014", "6:34", "am", "arg6", "10/3/2014", "7:34", "pm");
        assertEquals(new Integer(1), result.getExitCode());
     }

    @Ignore
      public void testOriginIsThreeLetters() {
        MainMethodResult result = invokeMain("CS410Airline",  "9879", "ABC", "10/3/2014", "7:22", "PM", "SFO", "10/22/2014", "8:22", "PM");
       assertEquals(new Integer(0), result.getExitCode());
    }

@Ignore
    public void testOriginIsNotAlpha() {
        MainMethodResult result = invokeMain("CS410Airline",  "9879", "A8D", "10/3/2014", "7:22", "pm", "arg5", "10/4/2014", "7:55", "pm");
       assertEquals(new Integer(1), result.getExitCode());
    }







}
