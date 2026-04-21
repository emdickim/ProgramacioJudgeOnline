package a19_01_arrayListWithNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayListWithNumbers {

    public int total(List<Integer> list) {
        // aixi es com ho faria de normal,
        // amb stream es una solucio interesant :D
        int sum = 0;

        for (Integer lol: list) {
            sum += lol;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    };

    public List<Integer> findPositions(List<Integer> list, int number) {

        List<Integer> llistaPosicions = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) llistaPosicions.add(i);
        }
        //System.out.println(llistaPosicions);

        return IntStream.range(0, list.size()).
                filter(i -> list.get(i) == number).
                boxed().
                toList();
    }

    public static void main(String[] args) {

        ArrayListWithNumbers p = new ArrayListWithNumbers();

        int[] numerets = {1, 2, 3, 8, 3, 7, 15, 22, 25, -4, 5, 12, 2, 8, 15, 0};

        List<Integer> llistaDeNumerets = new ArrayList<>();

        for (int i = 0; i < numerets.length; i++) {
            llistaDeNumerets.add(numerets[i]);
        }

        System.out.printf("1. Total%n" +
                          "2. Find positions%n" +
                          "Choose option:%n");

        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();

        if (opcio == 1)
            System.out.println(p.total(llistaDeNumerets));
        else {
            System.out.println("Enter number to find:");
            System.out.println(p.findPositions(llistaDeNumerets, sc.nextInt()));
        }



    }
}
