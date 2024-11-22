import textio.TextIO;

import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        String text; int charCount, wordFreq, wordCount, uniqueWords;
        char charFreq;
        
        System.out.println("Enter text...");
        text = TextIO.getln();
        String[] words = text.trim().replace(".", "").replace(",", "").split(" ");

        // the number of characcters
        charCount = text.length();

        // number of words
        wordCount = words.length;

        System.out.printf("The text has %d characters and %d words\n", charCount, wordCount);
        HashMap<Character, Integer> charTally = new HashMap<>();

        for(char c: text.toCharArray()) {
            // elimintating the empty spaces
            if(c != ' ') {
                if(charTally.containsKey(c)) {
                    int curr = charTally.get(c);
                    charTally.put(c, ++curr);
                } else {
                    charTally.put(c, 1);
                }
            }
        }

        // getting max key with max value from hashmap
        Map.Entry<Character, Integer> maxEntry = Collections.max(
                charTally.entrySet(),
                Map.Entry.comparingByValue()
        );

        System.out.println("The most common character is: " + maxEntry.getKey() + " with a frequency of: " + maxEntry.getValue());
        System.out.println("Enter a character to find it's frequency:");
        charFreq = TextIO.getlnChar();

        System.out.println("Frequency of " + charFreq + " is " + charTally.get(charFreq));
        System.out.println("Enter a word to find its frequency");
        String searchWord = TextIO.getlnWord();

        wordFreq = 0;
        for(String word: words) {
            if(word.equals(searchWord))
                ++wordFreq;
        }

        System.out.printf("The frequency of %s is %d\n", searchWord, wordFreq);

        uniqueWords = 0;
        for(String word: words) {
            List<String> wordList = Arrays.asList(words);

            // using the logic of a word not having more than one index to make it unique
            if(wordList.indexOf(word) == wordList.lastIndexOf(word))
                uniqueWords++;
        }

        System.out.println("The number of unique words are: " + uniqueWords);
    }
}