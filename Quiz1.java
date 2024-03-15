import java.util.*;
import java.io.*;

public class Quiz1 {
    public static void main(String[] args) throws IOException {

        boolean threeDotsFound = false;
        List<String> ignores = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while ((line = reader.readLine()) != null) {
            // strip leading and trailing white space
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (line.equals("...")) {
                threeDotsFound = true;
            } else if (threeDotsFound) {
                lines.add(line.toLowerCase());
            } else {
                ignores.add(line);
            }
        }
        reader.close();

        // list of string pairs
        List<String[]> pairs = new ArrayList<>();
        for (String line_ : lines) {
            String[] words = line_.split("\\s+");

            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                word = word.trim();
                if (!ignores.contains(word.toLowerCase())) {
                    String uppercase_word = word.toUpperCase();
                    String[] wordsCopy = words.clone();
                    wordsCopy[i] = uppercase_word;
                    String newLine = String.join(" ", wordsCopy);
                    pairs.add(new String[] {word, newLine});
                }
            }
        }

        Collections.sort(pairs, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                return a[0].compareTo(b[0]);
            }
        });

        for (String[] pair : pairs) {
            System.out.println(pair[1]);
        }
    }
}
