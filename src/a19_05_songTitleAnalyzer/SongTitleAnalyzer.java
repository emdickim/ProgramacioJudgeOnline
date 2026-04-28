package a19_05_songTitleAnalyzer;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class SongTitleAnalyzer {



    public static void main(String[] args) {

        SongTitleAnalyzer p = new SongTitleAnalyzer();

        String[] titols = {"Midnight Signals",
                "Echoes of You",
                "Fire in My Veins",
                "Dancing Through Silence",
                "Broken Neon Lights",
                "Forever Starts Tonight",
                "Whispers in the Dark",
                "Golden Hour Dreams",
                "Runaway Hearts",
                "Last Summer Again",
                "Shadows on Repeat",
                "Neon Skies Forever",
                "Heartbeat in Stereo",
                "Falling Without Gravity",
                "After the Last Goodbye",
                "City Lights on Fire",
                "Lost Between the Lines",
                "Dreaming in Slow Motion",
                "When the Night Breaks",
                "Echoes of a New Day"};

        List<String> llistaDeTitols= new ArrayList<>();

        for (int i = 0; i < titols.length; i++) {
            llistaDeTitols.add(titols[i]);
        }

        System.out.printf("1. Show title lengths\n" +
                "2. Find positions containing text\n" +
                "3. Filter titles containing text\n" +
                "4. Show titles sorted alphabetically\n" +
                "0. Exit\n" +
                "Choose option?%n");

        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();

        sc.nextLine();
        switch (opcio) {
            case 1 -> System.out.printf("1. Show title lengths: %s%n", p.getLengths(llistaDeTitols));
            case 2 -> {
                System.out.println("Enter text:");
                String lol = sc.nextLine();
                System.out.printf("Expenses: %s%n",
                        p.findPositionsContaining(llistaDeTitols, lol));
            }
            case 3 -> {
                System.out.println("Enter text::");
                String lol = sc.nextLine();
                System.out.printf("Expenses: %s%n",
                        p.filterContaining(llistaDeTitols, lol));
            }
            case 4 -> {
                System.out.println(p.sortAlphabetically(llistaDeTitols));
            }
            default -> {
                return;

            }
        }
    }

    public List<Integer> getLengths(List<String> list) {
        List<Integer> llistaDeLongituds = new ArrayList<>();

        for (String parauleta: list) {
            llistaDeLongituds.add(parauleta.length());
        }
        return llistaDeLongituds;
    }
    //Retorna un List<Integer> amb les posicions dels títols que contenen un text especificat, sense distingir majúscules i minúscules.
    public List<Integer> findPositionsContaining(List<String> list, String text) {

        List<Integer> llistaPosicions = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(text.toLowerCase())) llistaPosicions.add(i);
        }

        return llistaPosicions;
    }

    //Retorna un List<String> amb els títols que contenen un text especificat, sense distingir majúscules i minúscules.
    public List<String> filterContaining(List<String> list, String text) {
        List<String> llistaParauletes = new ArrayList<>();

        for (String s : list) {
            if (s.toLowerCase().contains(text.toLowerCase())) llistaParauletes.add(s);
        }

        return llistaParauletes;
    }

    //Retorna un List<String> amb els títols ordenats alfabèticament sense distingir entre majúscules i minúscules (ordenació case-insensitive).
    // Per exemple, "Echoes of a New Day" va abans que "Echoes of You".
    public List<String> sortAlphabetically(List<String> list) {
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }
}
