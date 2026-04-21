package ScannerTest;

import java.util.Scanner;

public class ScannerTest {

    static void main() {
        // string = Entrada.readLine();
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter text:%n");
        String text = sc.nextLine();

        System.out.printf("Text: %%n", text);

        //demanar un enter
        System.out.printf("Enter a number:");
        int number = sc.nextInt();
        System.out.printf("number: %d%n", number);

        double decimal = sc.nextDouble();
        System.out.printf("number: %f%n", decimal);

        sc.nextLine();
        System.out.println("Print dni");
        System.out.println("dini" + sc.nextLine());


        sc.close();//per educació
    }
}
