import java.lang.constant.Constable;
import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String[] args){
        String file1 = "tinyTale.txt";
        String file2 = "tale.txt";

        //This method will print out all word and appeared time in the file
        eachWordCount(file1);
        eachWordCount(file2);
        //This will print out the most frequent word in the files
        System.out.println(mostAppearWord(file1));
        System.out.println(mostAppearWord(file2));
    }
    public static Map<String, Integer> countWords(String fileName){

        Map<String, Integer> wordCounts = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.toLowerCase().trim().split("[\\W\\d]+");
                for (String word : words) {
                    if (!word.isEmpty()) { // ignore empty strings
                        if (!wordCounts.containsKey(word)) {
                            wordCounts.put(word, 1);
                        } else {
                            wordCounts.put(word, wordCounts.get(word) + 1);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return wordCounts;
    }
    public static String mostAppearWord(String fileName){
        Map<String, Integer> wordCounts = countWords("333/WordFrequency/" + fileName);
        int mostAppeared = 0;
        String wordMostAppear = "";
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > mostAppeared) {
                mostAppeared = entry.getValue();
                wordMostAppear = entry.getKey();
            }
        }
        return "The word \"" + wordMostAppear + "\" is the most appeared in " + fileName + " file with " + mostAppeared + " times.";
    }

    public static void eachWordCount(String fileName){
        Map<String, Integer> wordsCount = countWords("333/WordFrequency/" + fileName);
        System.out.println(fileName + " file has: ");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            String time = "";
            if (entry.getValue() == 1) {
                time = " time.";
            } else {
                time = " times.";
            }
            System.out.println("The word \"" + entry.getKey() + "\" appeared " + entry.getValue() + time);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
}