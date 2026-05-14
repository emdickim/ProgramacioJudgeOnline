package a25_01_spamDetector;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.HashSet;

public class SpamDetector {

    final static Scanner sc = new Scanner(System.in);
    
    public static final Set<String> SPAM_KEYWORDS = new HashSet<>(Set.of(
        "spoof", "limited offer", "bot", "scam",
        "virus", "hoax", "keygen", "hack", "crack",
        "earn money", "easy money", "clickbait", "win lottery",
        "win money", "urgent", "win prize", "fraudulent", "phishing",
        "bots", "malware", "nsfw", "trojan", "pirated",
        "fraud", "scammer", "scamming", "xxx", "fake",
        "free money", "make money", "spam", "adult", "click here",
        "ransomware", "get rich"
    ));


    
    public static Map<String, Integer> countForbiddenWords(String text, Set<String> forbiddenWords) {

        Map<String, Integer> parauletesRepetidetes = new HashMap<>();

        for (String word: forbiddenWords) {
            String pattern = "\\b" + word.toLowerCase() + "\\b";

            Matcher matcher = Pattern.compile(pattern).matcher(text.toLowerCase());

            int count = 0;

            while (matcher.find()) {
                count++;
            }

            if (count > 0) {
                parauletesRepetidetes.put(word, count);
            }

        }

        return parauletesRepetidetes;
    }

    public static void main(String[] args) {
        System.out.println(countForbiddenWords(sc.nextLine(), SPAM_KEYWORDS));
    }
}
