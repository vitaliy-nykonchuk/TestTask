package taskTwo.graph;

import taskTwo.app.City;
import java.util.*;

public class Graph {
    private final Map<String, Integer> cityIndexMap; // Map of city names to their indices
    private final List<City> cities; // List of city objects

    // Constructor to initialize the graph with a given number of cities
    public Graph(int cityCount) {
        cityIndexMap = new HashMap<>();
        cities = new ArrayList<>(cityCount);
    }

    // Add a city to the graph
    public void addCity(String name) {
        int index = cities.size(); // Assign the next available index
        cityIndexMap.put(name, index); // Map the city name to its index
        cities.add(new City(name)); // Add the city to the list
    }

    // Add a connection from one city to its neighbor with a specified cost
    public void addConnection(String cityName, int neighborIndex, int cost) {
        int cityIndex = cityIndexMap.get(cityName); // Get the index of the city
        cities.get(cityIndex).getNeighbors().put(neighborIndex, cost);
        // Add the neighbor and cost
    }

    // Find the minimum transportation cost between two cities
    public int findMinimumCost(String source, String destination) {
        int sourceIndex = cityIndexMap.get(source); // Get the index of the source city
        int destinationIndex = cityIndexMap.get(destination); // Get the index of the destination city

        // Initialize cost array with maximum values
        int[] costs = new int[cities.size()];
        Arrays.fill(costs, Integer.MAX_VALUE); // Set all costs to infinity initially
        costs[sourceIndex] = 0; // The cost to reach the source city is 0

        // Priority queue for processing cities based on current cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{sourceIndex, 0}); // Add the source city to the queue

        // Process each city in the queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // Get the city with the lowest cost
            int currentIndex = current[0];
            int currentCost = current[1];

            // Skip if this cost is already higher than the recorded cost
            if (currentCost > costs[currentIndex]) continue;

            // Check neighbors of the current city
            for (Map.Entry<Integer, Integer> neighbor : cities.get(currentIndex).getNeighbors().entrySet()) {
                int nextIndex = neighbor.getKey() - 1; // Adjust for 1-based indexing
                int nextCost = currentCost + neighbor.getValue(); // Calculate the cost to the neighbor

                // Update cost if a cheaper path is found
                if (nextCost < costs[nextIndex]) {
                    costs[nextIndex] = nextCost; // Update the cost to the neighbor
                    pq.add(new int[]{nextIndex, nextCost}); // Add the neighbor to the queue
                }
            }
        }

        return costs[destinationIndex]; // Return the minimum cost to the destination
    }
}