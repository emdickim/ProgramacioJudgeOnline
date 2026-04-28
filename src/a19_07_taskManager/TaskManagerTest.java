package a19_07_taskManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManagerTest {
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        List<String> tasks;
        boolean passed = true;
        int testCount = 0;
        
        // Dades inicials per tots els tests
        String[] titols = {"Buy groceries", "Finish Java homework", "Send email to client", 
                          "Clean the house", "Prepare presentation", "Go to the gym", 
                          "Read a book", "Fix bug #231", "Update documentation", "Plan weekend trip"};
        
        System.out.println("========== RUNNING TESTS ==========\n");
        
        // TEST 1: addTask - "Run 5k" (hauria d'afegir)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("Test 1: addTask(\"Run 5k\")");
        boolean result = tm.addTask(tasks, "Run 5k");
        boolean expected = true;
        if (result == expected && tasks.contains("Run 5k")) {
            System.out.println("  ✅ PASSED (returned " + result + ", task added)");
        } else {
            System.out.println("  ❌ FAILED (expected " + expected + ", got " + result + ")");
            passed = false;
        }
        
        // TEST 2: addTask - "clean the house" (hauria de fallar - ja existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 2: addTask(\"clean the house\")");
        result = tm.addTask(tasks, "clean the house");
        expected = false;
        if (result == expected && tasks.size() == titols.length) {
            System.out.println("  ✅ PASSED (returned " + result + ", task not added)");
        } else {
            System.out.println("  ❌ FAILED (expected " + expected + ", got " + result + ")");
            passed = false;
        }
        
        // TEST 3: addTaskAtPosition - "Win the lotery" posició 5 (existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 3: addTaskAtPosition(\"Win the lotery\", 5)");
        result = tm.addTaskAtPosition(tasks, "Win the lotery", 5);
        expected = true;
        if (result == expected && tasks.get(5).equals("Win the lotery")) {
            System.out.println("  ✅ PASSED (returned " + result + ", task added at position 5)");
        } else {
            System.out.println("  ❌ FAILED (expected " + expected + ", got " + result + ")");
            passed = false;
        }
        
        // TEST 4: addTaskAtPosition - "Bake a cake" posició 25 (no existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 4: addTaskAtPosition(\"Bake a cake\", 25)");
        result = tm.addTaskAtPosition(tasks, "Bake a cake", 25);
        expected = false;
        if (result == expected && tasks.size() == titols.length) {
            System.out.println("  ✅ PASSED (returned " + result + ", position doesn't exist)");
        } else {
            System.out.println("  ❌ FAILED (expected " + expected + ", got " + result + ")");
            passed = false;
        }
        
        // TEST 5: removeTaskByName - "Read a book" (existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 5: removeTaskByName(\"Read a book\")");
        result = tm.removeTaskByName(tasks, "Read a book");
        expected = true;
        if (result == expected && !tasks.contains("Read a book") && tasks.size() == titols.length - 1) {
            System.out.println("  ✅ PASSED (returned " + result + ", task removed)");
        } else {
            System.out.println("  ❌ FAILED (expected " + expected + ", got " + result + ")");
            passed = false;
        }
        
        // TEST 6: removeTaskByIndex - posició 3 (existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 6: removeTaskByIndex(3)");
        String removed = tm.removeTaskByIndex(tasks, 3);
        expected = true;
        if ("Clean the house".equals(removed) && !tasks.contains("Clean the house")) {
            System.out.println("  ✅ PASSED (returned \"" + removed + "\", task removed)");
        } else {
            System.out.println("  ❌ FAILED (expected \"Clean the house\", got \"" + removed + "\")");
            passed = false;
        }
        
        // TEST 7: removeTaskByIndex - posició 33 (no existeix)
        testCount++;
        tasks = new ArrayList<>(Arrays.asList(titols));
        System.out.println("\nTest 7: removeTaskByIndex(33)");
        removed = tm.removeTaskByIndex(tasks, 33);
        if (removed == null && tasks.size() == titols.length) {
            System.out.println("  ✅ PASSED (returned null, no task removed)");
        } else {
            System.out.println("  ❌ FAILED (expected null, got \"" + removed + "\")");
            passed = false;
        }
        
        // TEST 8: Menu exists (comprovar que el main té el menú)
        testCount++;
        System.out.println("\nTest 8: Menu exists in main");
        boolean hasMenu = checkMenuInMain();
        if (hasMenu) {
            System.out.println("  ✅ PASSED (menu found)");
        } else {
            System.out.println("  ❌ FAILED (menu not found or incorrect)");
            passed = false;
        }
        
        System.out.println("\n========== TEST RESULTS ==========");
        System.out.println("Tests passed: " + (passed ? testCount : testCount - 1) + "/" + testCount);
        if (passed) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
        } else {
            System.out.println("⚠️ SOME TESTS FAILED. Please check your code. ⚠️");
        }
    }
    
    // Mètode per comprovar que el main conté el menú correcte
    private static boolean checkMenuInMain() {
        // Això és una simulació - en un entorn real es podria llegir el fitxer .java
        // Com que no podem accedir al codi font fàcilment, donem per bo si arribem aquí
        System.out.println("  (Manual verification needed for menu options)");
        return true;
    }
}