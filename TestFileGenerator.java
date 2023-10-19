import java.io.*;
import java.util.*;

public class TestFileGenerator {
  static Random random = new Random();

  public static void GenerateInputFile(int n, String fileName) {
    // Check if the file already exists
    File file = new File(fileName);
    if (file.exists())
      return;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      // Writing the number of cities
      writer.write(n + "\n");

      // Writing the cost of petrol in each city
      for (int i = 0; i < n; i++) {
        int cost = 1 + random.nextInt(1000000); // generating random cost between 1 and 1000000
        writer.write(cost + (i < n - 1 ? " " : "\n"));
      }

      // Generating edges to form a tree structure
      for (int i = 2; i <= n; i++) {
        int parent = 1 + random.nextInt(i - 1); // parent city index, ensuring it's less than current city index
        int weight = 1 + random.nextInt(1000000); // generating random weight between 1 and 1000000
        writer.write(parent + " " + weight + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}