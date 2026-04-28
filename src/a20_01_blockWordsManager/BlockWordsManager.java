package a20_01_blockWordsManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockWordsManager {

    //Afegeix una paraula al conjunt si aquesta no existeix.
    // El conjunt conté totes les paraules en minúscules, per tant, abans d'afegir-la, converteix-la paraula a minúscules.
    // Retorna true si la paraula s'afegeix satisfactòriament, false en cas contrari.

    public boolean addWord(Set<String> words, String word) {
        return (words.add(word.toLowerCase())) ? "Word added" : "dd";
    }

    //Comprova si una paraula està inclosa al conjunt (ignora majúscules i minúscules). Retorna true si el conjunt conté la paraula.

    public boolean containsWord(Set<String> words, String word) {


    }

    //Elimina una paraula del conjunt si aquesta existeix (ignora majúscules i minúscules).
    // Retorna true si la paraula és esborrada satisfactòriament o false en cas contrari.

    public boolean removeWord(Set<String> words, String word)
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
    }
}
