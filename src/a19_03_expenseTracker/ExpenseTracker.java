package a19_03_expenseTracker;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExpenseTracker {



    public double totalExpenses(List<Float> list) {
        double sum = 0;

        double[] decimals = {0};
        list.forEach(p -> decimals[0] += p);
        //return list.stream().mapToDouble(Float::floatValue).sum();
        return decimals[0];
    }

    public float totalAbove(List<Float> list, float amount) {

        List<Float> llistaFiltrada  = new ArrayList<>();

        float suma = 0;
        for(float num : list) {
            if (num >= amount) suma += num;
        }

        //return (float) list.stream().filter(n -> n >= amount).mapToDouble(Float::floatValue).sum();
        return list.stream().filter(n -> n >= amount).reduce(0.0f, Float::sum);
    }

    public float totalWithTolerance(List<Float> list, float amount, float tolerance) {
        float total = 0;
        for (float num : list) {
            if (amount-tolerance <= num && amount+ tolerance >= num) total += num;
        }
        return total;
    }

    public static void main(String[] args) {

        ExpenseTracker p = new ExpenseTracker();

        float[] numerets = {12.5f, 13.55f, 23.5f, 123.45f, 122.52f, 113.46f,
                143.3f, 123.4f, 126.55f, 7.8f, 122.6f, 185.3f,
                210.59f, 1.99f, 155.0f, 55.4f, 254.35f, 122.55f,
                120.99f, 121.0f};

        List<Float> llistaDeNumerets = new ArrayList<>();

        for (int i = 0; i < numerets.length; i++) {
            llistaDeNumerets.add(numerets[i]);
        }

        System.out.printf("1. Total expenses%n" +
                "2. Total expenses above amount%n" +
                "3. Total expenses with tolerance%n" +
                "Choose option:%n");

        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();

        switch (opcio) {
            case 1 -> System.out.printf("Total expenses: %.2f%n", p.totalExpenses(llistaDeNumerets));
            case 2 -> {
                System.out.println("Enter amount:");
                System.out.printf("Expenses: %.2f%n", p.totalAbove(llistaDeNumerets, sc.nextFloat()));
            }
            default -> {
                System.out.println("Enter value:");
                float value = sc.nextInt();
                System.out.println("Enter tolerance:");

                System.out.printf("Expenses: %.2f%n", p.totalWithTolerance(llistaDeNumerets, value, sc.nextFloat()));

            }
        }



    }
}


