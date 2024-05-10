import java.util.*;

public class IteratorManipulation {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // ArrayList with random integers 
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }

        int sum = 0;
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            System.out.println(current);
            sum += current;

            // Remove integers > 50
            if (current > 50) {
                iterator.remove(); // Safe removal (add caused ConcurrentModificationException)
            }
        }
        
        System.out.println("Modified List: " + numbers);
        System.out.println("Total sum: " + sum);

        // HashMap
        HashMap<String, Integer> items = new HashMap<>();
        items.put("Books", 12);
        items.put("Movies", 8);
        items.put("Games", 15);
        items.put("Music", 20);
        items.put("Food", 30);

        Iterator<Map.Entry<String, Integer>> entryIterator = items.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());

            // Increase Books count
            if (entry.getKey().equals("Books")) {
                entry.setValue(entry.getValue() + 5); 
            }

            if (entry.getKey().equals("Food")) {
                entryIterator.remove(); // Safe removal 
            }
        }
        
        System.out.println("Modified List: " + items);

        // TreeMap 
        TreeMap<String, Double> temperatures = new TreeMap<>();
        temperatures.put("January", 31.5);
        temperatures.put("February", 43.0);
        temperatures.put("March", 52.0);
        temperatures.put("April", 58.0);
        temperatures.put("May", 69.0);
        temperatures.put("June", 77.0);

        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        String maxMonth = "";
        String minMonth = "";

        Iterator<Map.Entry<String, Double>> treeMapIterator = temperatures.entrySet().iterator();
        while (treeMapIterator.hasNext()) {
            Map.Entry<String, Double> entry = treeMapIterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());

            if (entry.getValue() > maxTemp) {
                maxTemp = entry.getValue();
                maxMonth = entry.getKey();
            }
            if (entry.getValue() < minTemp) {
                minTemp = entry.getValue();
                minMonth = entry.getKey();
            }
        }

        System.out.println("Highest Temperature: " + maxTemp + " in " + maxMonth);
        System.out.println("Lowest Temperature: " + minTemp + " in " + minMonth);
    }
}

