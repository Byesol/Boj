import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // Use a HashMap to count items for each clothing type.
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // The number of combinations is the product of (count + 1) for each type.
        // Start with 1, the identity for multiplication.
        int answer = 1;
        for (int count : map.values()) {
            // For each type, we can either wear one of the items or none (+1).
            answer *= (count + 1);
        }

        // Subtract 1 to exclude the case where nothing is worn at all.
        return answer - 1;
    }
}