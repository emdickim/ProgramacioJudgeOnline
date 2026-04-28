package a20_01_blockWordsManager;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BlockWordsManager {

    //Afegeix una paraula al conjunt si aquesta no existeix.
    // El conjunt conté totes les paraules en minúscules, per tant, abans d'afegir-la, converteix-la paraula a minúscules.
    // Retorna true si la paraula s'afegeix satisfactòriament, false en cas contrari.

    public boolean addWord(Set<String> words, String word) {
        /*if (words.add(word)) {
            System.out.println("Word added");
            return true;
        }

        System.out.println("Word");
        return false;*/
        return words.add(word.toLowerCase());
    }

    //Comprova si una paraula està inclosa al conjunt (ignora majúscules i minúscules). Retorna true si el conjunt conté la paraula.

    public boolean containsWord(Set<String> words, String word) {

        return words.stream().anyMatch(w -> w.equalsIgnoreCase(word));


    }

    //Elimina una paraula del conjunt si aquesta existeix (ignora majúscules i minúscules).
    // Retorna true si la paraula és esborrada satisfactòriament o false en cas contrari.

    public boolean removeWord(Set<String> words, String word) {
        if (words.removeIf(w -> w.equalsIgnoreCase(word))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        BlockWordsManager p = new BlockWordsManager();
        Set<String> parauletes = new HashSet<>(Set.of(
                "spam", "scam", "fake", "clickbait", "hack", "virus",
                "phishing", "malware", "trojan", "ransomware",
                "fraud", "fraudulent", "hoax", "spoof",
                "bot", "bots", "scammer", "scamming",
                "free money", "get rich", "lottery", "prize",
                "win now", "urgent", "limited offer",
                "adult", "xxx", "nsfw",
                "crack", "pirated", "keygen"));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. List words\r\n" + //
                                "2. Add a new word\r\n" + //
                                "3. Check if a word exists\r\n" + //
                                "4. Remove word\r\n" + //
                                "0. Exit\r\n" + //
                                "Choose option:");
            

            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio) {
                case 0 -> {
                    return;
                }
                case 1 -> System.out.println(parauletes);
                case 2 -> {
                    System.out.println("Enter word to add:");
                    System.out.println((p.addWord(parauletes, sc.nextLine())) ? "Word added" : "Word already exists" ); 
                }
                case 3 -> {
                    System.out.println("Enter word to check:");
                    String name = sc.nextLine();
                    System.out.println((p.containsWord(parauletes, sc.nextLine())) ? 
                    "Word exists" : "Word does not exist" ); 
                }
                default -> {
                    System.out.println("Enter word to remove:");
                    String name = sc.nextLine();
                    System.out.println((p.removeWord(parauletes, sc.nextLine())) ? 
                    "Word removed" : "Word does not exist" ); 
                }
            }
        }
    }
}
