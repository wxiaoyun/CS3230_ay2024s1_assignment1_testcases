import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class TestTimeComplexity {

  public static String testFileDir = TestSolution.testFileDir;

  private static final String[] inputFiles = {
      testFileDir + "10.txt",
      testFileDir + "20.txt",
      testFileDir + "50.txt",
      testFileDir + "100.txt",
      testFileDir + "1000.txt",
      testFileDir + "10000.txt",
  };

  private static final int[] inputSizes = {
      10,
      20,
      50,
      100,
      1000,
      10000,
  };

  @Test
  public void testTimeComplexityMST() throws Exception {
    initLargeInput();

    long[] times = new long[inputFiles.length];
    for (int i = 0; i < inputFiles.length; i++) {
      // Set up input redirection
      FileInputStream inputFileStream = new FileInputStream(inputFiles[i]);
      System.setIn(inputFileStream);

      // Set up output capture
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos);
      System.setOut(ps);

      // Run the solution
      long startTime = System.nanoTime();
      Main.main(new String[] {});
      long endTime = System.nanoTime();

      // Restore System.in and System.out
      System.setIn(System.in);
      System.setOut(System.out);

      // Close input file stream
      inputFileStream.close();

      times[i] = endTime - startTime;
    }

    testPolynomialTimeComplexity(times, 3);

    testPolynomialTimeComplexity(times, 2);
  }

  private static void initLargeInput() {
    for (int i = 0; i < inputFiles.length; i++) {
      TestFileGenerator.GenerateInputFile(inputSizes[i], inputFiles[i]);
    }
  }

  /**
   * Tests that the time complexity of the given algorithm is O(n^pow).
   */
  private void testPolynomialTimeComplexity(long[] times, double pow) {
    for (int i = 1; i < times.length; i++) {
      double previousN = inputSizes[i - 1];
      double currentN = inputSizes[i];
      double previousTime = times[i - 1];
      double currentTime = times[i];

      double expectedTimeGrowth = Math.pow(currentN / previousN, pow);
      double actualTimeGrowth = currentTime / previousTime;

      // You may want to use a tolerance value to account for small variations in time
      // measurements
      double tolerance = 0.25;
      double upperBound = expectedTimeGrowth * (1 + tolerance);
      System.out.printf("Test %d:\nTime taken: %.7f\nExpected time growth: %f\nActual time " +
          "growth: " +
          "%f%n",
          i, times[i] / 1_000_000_000.0, expectedTimeGrowth, actualTimeGrowth);
      assertTrue(
          String.format("Time complexity is worse than O(n^%.0f)", pow),
          actualTimeGrowth <= upperBound);
    }
  }
}
