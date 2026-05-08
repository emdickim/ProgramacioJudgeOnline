package a23_01_clientManager;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClientManager CM = new ClientManager();
        while (true) {
            System.out.println("MENU\n" +
                    "1. LIST CLIENTS\n" +
                    "2. GET CLIENT BY ACCOUNT AND DNI\n" +
                    "3. ADD NEW CLIENT\n" +
                    "4. UPDATE CLIENT BY ACCOUNT AND DNI\n" +
                    "5. REMOVE CLIENT BY ACCOUNT AND DNI\n" +
                    "0. EXIT\n" +
                    "OPTION?");

            int opcio = scanner.nextInt();

            scanner.nextLine();

            switch (opcio) {
                case 0 -> {
                    scanner.close();
                    return;
                }
                case 1 -> {
                    CM.listClients();
                }
                case 2 -> {
                    System.out.println("Enter account:");
                    String account = scanner.nextLine();
                    System.out.println("Enter dni:");
                    String dni = scanner.nextLine();
                    System.out.println(CM.getClientByAccountAndDni(account, dni));

                }
                case 3 -> {
                    System.out.println("Enter account:");
                    String account = scanner.nextLine();
                    System.out.println("Enter dni:");
                    String dni = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter phone:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter balance:");
                    float balance = scanner.nextFloat();
                    scanner.nextLine();
                    
                    Client newClient = new Client(account, dni, phone, surname, name, balance);
                    System.out.println(CM.addClient(newClient));
                }
                case 4 -> {
                    System.out.println("Enter account:");
                    String account = scanner.nextLine();
                    System.out.println("Enter dni:");
                    String dni = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter phone:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter balance:");
                    float balance = scanner.nextFloat();
                    scanner.nextLine();
                    
                    Client updatedClient = new Client(account, dni, phone, surname, name, balance);
                    System.out.println(CM.updateClient(account, dni, updatedClient));
                }
                case 5 -> {
                    System.out.println("Enter account:");
                    String account = scanner.nextLine();
                    System.out.println("Enter dni:");
                    String dni = scanner.nextLine();
                    System.out.println(CM.removeClient(account, dni));
                }
            }
        }
    }
}
