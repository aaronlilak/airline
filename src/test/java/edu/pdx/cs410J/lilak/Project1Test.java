package edu.pdx.cs410J.lilak;

import edu.pdx.cs410J.InvokeMainTestCase;
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
  @Test
  public void testNoCommandLineArgumentsError() {
    MainMethodResult result = invokeMain();
    assertEquals(new Integer(1), result.getExitCode());
  }

  @Test
  public void testFiveCommandLineArgumentsError() {
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX", "7/5/2014", "20:07", "MDW");
    assertEquals(new Integer(1), result.getExitCode());
  }

  @Test
  public void testEightCommandLineArgumentsGood() {
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX",  "7/5/2014", "18:07", "MDW", "7/5/2014", "20:07");
    assertEquals(new Integer(0), result.getExitCode());
  }

  @Test
   public void testFiveCommandLineArgumentsWithReadme() {
     MainMethodResult result = invokeMain("-README","CS410Airline", "1503", "PDX", "7/5/2014", "20:07", "MDW");
     assertEquals(new Integer(0), result.getExitCode());
   }

  @Test
  public void testReadmeWithNoArgsIsOK() {
    MainMethodResult result = invokeMain("-README");
      assertEquals(new Integer(0), result.getExitCode());
  }

  @Test
  public void testReadmeWithSomeArgsIsOK() {
      MainMethodResult result = invokeMain("CS410Airline", "-README");
      assertEquals(new Integer(0), result.getExitCode());
  }

  @Test
    public void testFlightNumberIsNotInteger() {
      MainMethodResult result = invokeMain("CS410Airline", "notinteger");
      assertEquals(new Integer(1), result.getExitCode());
      //result = invokeMain("CS410Airline",  "9879");
      //assertEquals(new Integer(0), result.getExitCode());
       //result = invokeMain("CS410Airline",  "-9879");
       //assertEquals(new Integer(1), result.getExitCode());
     }

      @Test
        public void testFlightNumberIsReallyInteger() {
          MainMethodResult result = invokeMain("CS410Airline",  "9879", "PDX", "10/3/2014", "18:34", "SFO", "10/4/2014", "19:33");
         assertEquals(new Integer(0), result.getExitCode());
      }

      @Test
        public void testFlightNumberIsPositiveInteger() {
          MainMethodResult result = invokeMain("CS410Airline",  "-9879", "PDX", "10/3/2014", "18:34", "SFO", "10/3/2014", "19:34");
         assertEquals(new Integer(1), result.getExitCode());
      }

     @Test
       public void testOriginIsFourLetters() {
         MainMethodResult result = invokeMain("CS410Airline",  "9879", "ABCD", "10/3/2014", "18:34", "arg6", "10/3/2014", "19:34");
        assertEquals(new Integer(1), result.getExitCode());
     }

    @Test
      public void testOriginIsThreeLetters() {
        MainMethodResult result = invokeMain("CS410Airline",  "9879", "ABC", "10/3/2014", "19:22", "SFO", "10/22/2014", "20:22");
       assertEquals(new Integer(0), result.getExitCode());
    }

    @Test
      public void testOriginIsNotAlpha() {
        MainMethodResult result = invokeMain("CS410Airline",  "9879", "A8D", "10/3/2014", "19:22", "arg5", "10/4/2014", "19:55");
       assertEquals(new Integer(1), result.getExitCode());
    }







}