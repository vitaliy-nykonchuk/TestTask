package taskTwo.model;

import taskTwo.graph.Graph;
import java.io.*;

public class ApplicationLogic {
    public void runApp(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            // Read the number of test cases
            int testCount = Integer.parseInt(reader.readLine().trim());

            for (int t = 0; t < testCount; t++) {
                // Read the number of cities
                int cityCount = Integer.parseInt(reader.readLine().trim());
                Graph graph = new Graph(cityCount); // Initialize the graph

                // Process each city
                for (int i = 0; i < cityCount; i++) {
                    String cityName = reader.readLine().trim(); // Read city name
                    graph.addCity(cityName); // Add city to the graph

                    // Read the number of neighbors for the city
                    int neighborCount = Integer.parseInt(reader.readLine().trim());
                    for (int j = 0; j < neighborCount; j++) {
                        String[] neighborData = reader.readLine().trim().split(" "); // Split neighbor data
                        int neighborIndex = Integer.parseInt(neighborData[0]); // Get neighbor index
                        int cost = Integer.parseInt(neighborData[1]); // Get transportation cost
                        graph.addConnection(cityName, neighborIndex, cost); // Add the connection
                    }
                }

                // Read the number of routes to process
                int routeCount = Integer.parseInt(reader.readLine().trim());
                for (int r = 0; r < routeCount; r++) {
                    String[] route = reader.readLine().trim().split(" "); // Read the route
                    String source = route[0]; // Get the source city
                    String destination = route[1]; // Get the destination city
                    int cost = graph.findMinimumCost(source, destination); // Find the minimum cost
                    writer.write(cost + "\n"); // Write the result to the output file
                }

                // Skip the blank line separating test cases
                if (t < testCount - 1) {
                    reader.readLine(); // Consume the blank line
                }
            }
        }
    }
}