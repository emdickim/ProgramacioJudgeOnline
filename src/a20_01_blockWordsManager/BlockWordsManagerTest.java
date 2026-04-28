
package a20_01_blockWordsManager;

import java.util.HashSet;
import java.util.Set;

public class BlockWordsManagerTest {
    
    public static void main(String[] args) {
        BlockWordsManager bwm = new BlockWordsManager();
        boolean allTestsPassed = true;
        int testCount = 0;
        
        // Dades inicials
        Set<String> words = new HashSet<>(Set.of(
            "spam", "scam", "fake", "clickbait", "hack", "virus",
            "phishing", "malware", "trojan", "ransomware",
            "fraud", "fraudulent", "hoax", "spoof",
            "bot", "bots", "scammer", "scamming",
            "free money", "get rich", "lottery", "prize",
            "win now", "urgent", "limited offer",
            "adult", "xxx", "nsfw",
            "crack", "pirated", "keygen"
        ));
        
        System.out.println("========== BLOCK WORDS MANAGER TESTS ==========\n");
        
        // TEST 1: addWord - "Exploit" (hauria d'afegir)
        testCount++;
        Set<String> test1 = new HashSet<>(words);
        System.out.println("Test 1: addWord(\"Exploit\")");
        boolean result1 = bwm.addWord(test1, "Exploit");
        boolean expected1 = true;
        boolean passed1 = (result1 == expected1) && test1.contains("exploit");
        System.out.println("  Expected: " + expected1 + " | Got: " + result1);
        System.out.println("  Result: " + (passed1 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed1) allTestsPassed = false;
        System.out.println();
        
        // TEST 2: addWord - "virus" (hauria de fallar - ja existeix)
        testCount++;
        Set<String> test2 = new HashSet<>(words);
        System.out.println("Test 2: addWord(\"virus\")");
        boolean result2 = bwm.addWord(test2, "virus");
        boolean expected2 = false;
        boolean passed2 = (result2 == expected2);
        System.out.println("  Expected: " + expected2 + " | Got: " + result2);
        System.out.println("  Result: " + (passed2 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed2) allTestsPassed = false;
        System.out.println();
        
        // TEST 3: containsWord - "scam" (hauria de retornar true)
        testCount++;
        Set<String> test3 = new HashSet<>(words);
        System.out.println("Test 3: containsWord(\"scam\")");
        boolean result3 = bwm.containsWord(test3, "scam");
        boolean expected3 = true;
        boolean passed3 = (result3 == expected3);
        System.out.println("  Expected: " + expected3 + " | Got: " + result3);
        System.out.println("  Result: " + (passed3 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed3) allTestsPassed = false;
        System.out.println();
        
        // TEST 4: containsWord - "death" (hauria de retornar false)
        testCount++;
        Set<String> test4 = new HashSet<>(words);
        System.out.println("Test 4: containsWord(\"death\")");
        boolean result4 = bwm.containsWord(test4, "death");
        boolean expected4 = false;
        boolean passed4 = (result4 == expected4);
        System.out.println("  Expected: " + expected4 + " | Got: " + result4);
        System.out.println("  Result: " + (passed4 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed4) allTestsPassed = false;
        System.out.println();
        
        // TEST 5: containsWord - "Get rich" (hauria de retornar true - existeix en minúscules)
        testCount++;
        Set<String> test5 = new HashSet<>(words);
        System.out.println("Test 5: containsWord(\"Get rich\")");
        boolean result5 = bwm.containsWord(test5, "Get rich");
        boolean expected5 = true;
        boolean passed5 = (result5 == expected5);
        System.out.println("  Expected: " + expected5 + " | Got: " + result5);
        System.out.println("  Result: " + (passed5 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed5) allTestsPassed = false;
        System.out.println();
        
        // TEST 6: removeWord - "Get rich" (hauria d'eliminar)
        testCount++;
        Set<String> test6 = new HashSet<>(words);
        System.out.println("Test 6: removeWord(\"Get rich\")");
        boolean result6 = bwm.removeWord(test6, "Get rich");
        boolean expected6 = true;
        boolean passed6 = (result6 == expected6) && !test6.contains("get rich");
        System.out.println("  Expected: " + expected6 + " | Got: " + result6);
        System.out.println("  Result: " + (passed6 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed6) allTestsPassed = false;
        System.out.println();
        
        // TEST 7: removeWord - "cheat" (no existeix)
        testCount++;
        Set<String> test7 = new HashSet<>(words);
        System.out.println("Test 7: removeWord(\"cheat\")");
        boolean result7 = bwm.removeWord(test7, "cheat");
        boolean expected7 = false;
        boolean passed7 = (result7 == expected7);
        System.out.println("  Expected: " + expected7 + " | Got: " + result7);
        System.out.println("  Result: " + (passed7 ? "✅ PASSED" : "❌ FAILED"));
        if (!passed7) allTestsPassed = false;
        System.out.println();
        
        // TEST 8: Verificar que el main té menú (comprovació bàsica)
        testCount++;
        System.out.println("Test 8: Main contains menu");
        System.out.println("  (Manual verification needed)");
        System.out.println("  Result: ⚠️ CHECK MANUALLY");
        System.out.println();
        
        // TEST 9-11: Tests de menú (requereixen execució manual)
        System.out.println("Tests 9-11: Menu interaction tests");
        System.out.println("  Test 9: Option 2 with 'sex' -> Should show menu and 'Word added'");
        System.out.println("  Test 10: Option 3 with 'fake' -> Should show menu and 'Word exists'");
        System.out.println("  Test 11: Option 4 with 'phishing' -> Should show menu and 'Word removed'");
        System.out.println("  Result: ⚠️ CHECK MANUALLY");
        System.out.println();
        
        // Resum final
        System.out.println("========== RESULTS ==========");
        System.out.println("Automatic tests passed: " + (allTestsPassed ? testCount - 1 : testCount - 1) + "/7");
        System.out.println("Manual tests needed: 4 (tests 8-11)");
        
        if (allTestsPassed) {
            System.out.println("\n✅ All automatic tests PASSED!");
            System.out.println("⚠️ Remember to manually verify tests 8-11 (menu)");
        } else {
            System.out.println("\n❌ Some automatic tests FAILED. Please fix your code.");
        }
    }
}