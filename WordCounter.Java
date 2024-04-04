import java.util.HashMap;

public class WordCounter {
    public static void main(String[] args) {
        String str = "Hello world, this is a test string. Count the words in this string using HashMap.";

        str = str.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = str.split("\\s+");

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        
        System.out.println("Word Count:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
