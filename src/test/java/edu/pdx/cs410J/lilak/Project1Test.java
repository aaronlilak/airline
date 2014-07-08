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
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX", "20:07 7/5/2014", "MDW");
    assertEquals(new Integer(1), result.getExitCode());
  }

  @Test
  public void testSixCommandLineArgumentsGood() {
    MainMethodResult result = invokeMain("CS410Airline", "1503", "PDX", "20:07 7/5/2014", "MDW", "23:38 7/5/2014");
    assertEquals(new Integer(0), result.getExitCode());
  }

  @Test
   public void testFiveCommandLineArgumentsWithReadme() {
     MainMethodResult result = invokeMain("-README","CS410Airline", "1503", "PDX", "20:07 7/5/2014", "MDW");
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
    public void testFlightNumberIsInteger() {
        MainMethodResult result = invokeMain("CS410Airline", "9879");
        assertEquals(new Integer(0), result.getExitCode());