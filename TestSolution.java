import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
  private static String testFileDir = "/absolute/path_to/test_file_dir/";

  @Test
  public void testSolution() throws Exception {

    String[] inputFiles = { TestSolution.testFileDir + "input1.txt", TestSolution.testFileDir + "input2.txt" };
    String[] outputFiles = { TestSolution.testFileDir + "output1.txt", TestSolution.testFileDir + "output2.txt" };

    for (int i = 0; i < inputFiles.length; i++) {
      File file = new File(inputFiles[i]);
      if (!file.exists()) {
        System.out.println("File " + inputFiles[i] + " does not exist.");
        // remind the user to put edit the testFileDir variable
        System.out
            .println("Please edit the testFileDir variable in TestSolution.java to point to the correct directory.");
        System.exit(1);
      }

      // Set up input redirection
      FileInputStream inputFileStream = new FileInputStream(inputFiles[i]);
      System.setIn(inputFileStream);

      // Set up output capture
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos);
      System.setOut(ps);

      // Run the solution
      Solution.main(new String[] {});

      // Restore System.in and System.out
      System.setIn(System.in);
      System.setOut(System.out);

      // Close input file stream
      inputFileStream.close();

      // Get the captured output
      String output = baos.toString().trim();

      // Get the expected output
      String expectedOutput = new String(Files.readAllBytes(Paths.get(outputFiles[i]))).trim();

      // Compare the captured output to the expected output
      assertEquals(expectedOutput, output);
    }
  }
}
