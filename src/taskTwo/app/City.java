package taskTwo.app;

import java.util.HashMap;
import java.util.Map;

public class City {
    private final Map<Integer, Integer> neighbors;

    public City(String name) {
        this.neighbors = new HashMap<>();
    }

    // Getter for neighbors
    public Map<Integer, Integer> getNeighbors() {
        return neighbors;
    }
}