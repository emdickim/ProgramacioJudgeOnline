package a21_02_shopQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shop shop = new Shop("Ebay");
        List<Product> llistaProductes = new ArrayList<>();
        afegirProductes(llistaProductes);
        shop.setProducts(llistaProductes);
        while (true) {
            System.out.println("MENU\n" +
                    "1. LIST PRODUCTS BY NAME AND SIZE\n" +
                    "2. GET TOTAL OF ACTIVE PRODUCTS\n" +
                    "3. GET TOTAL BY SIZE\n" +
                    "4. GET AVERAGE OF ACTIVE PRODUCTS\n" +
                    "0. EXIT\n" +
                    "OPTION?");

            int opcio = scanner.nextInt();

            scanner.nextLine();

            switch (opcio) {
                case 0 -> {
                    scanner.close();
                    return;
                }
                case 7 -> {
                    shop.listProducts();
                }
                case 1 -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter size (1.XXS, 2.XS, 3.S, 4.M, 5.L, 6.XL, 7.XXL):");
                    int sizeOption = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    Size size = whatSize(sizeOption);
                    shop.listProductsNameAndSize(name, size).forEach(System.out::println);
                }
                case 2 -> {
                    System.out.printf("%.2f%n", shop.totalActive());
                }
                case 3 -> {
                    System.out.println("Enter size (1.XXS, 2.XS, 3.S 4.M, 5.L, 6.XL, 7.XXL):");
                    Size size = whatSize(scanner.nextInt());
                    System.out.println(shop.totalBySize(size));
                }
                case 4 -> System.out.printf("%.2f%n", shop.averageActive());
            }
        }
    }

    
    private static Size whatSize(int nextInt) {
        return switch (nextInt) {
            case 1 -> Size.XXS;
            case 2 -> Size.XS;
            case 3 -> Size.S;
            case 4 -> Size.M;
            case 5 -> Size.L;
            case 6 -> Size.XL;
            case 7 -> Size.XXL;
            default -> Size.M;
        };
    }

    private static void afegirProductes(List<Product> llistaProductes) {
        llistaProductes.add(new Product("TSHIRT", Size.XXS, 30.25f, true));
        llistaProductes.add(new Product("CAP", Size.XS, 25.75f, true));
        llistaProductes.add(new Product("TROUSERS", Size.S, 30.25f, true));
        llistaProductes.add(new Product("SKIRT", Size.M, 28.25f, true));
        llistaProductes.add(new Product("GLOVES", Size.L, 32.35f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XL, 23.79f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XXL, 35.25f, true));
        llistaProductes.add(new Product("JACKET", Size.XL, 59.97f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 29.95f, true));
        llistaProductes.add(new Product("LONG-SHIRT", Size.XS, 20.56f, true));
        llistaProductes.add(new Product("TANK-TSHIRT", Size.XL, 16.55f, true));
        llistaProductes.add(new Product("TSHIRT", Size.M, 29.15f, true));
        llistaProductes.add(new Product("TANK-TSHIRT", Size.XXL, 24.45f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 32.50f, true));
        llistaProductes.add(new Product("LONG-SHIRT", Size.XS, 32.70f, false));
        llistaProductes.add(new Product("SHIRT", Size.XS, 34.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 33.25f, false));
        llistaProductes.add(new Product("SLEEVELESS-SHIRT", Size.XS, 32.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 28.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.S, 29.50f, false));
    }

}
