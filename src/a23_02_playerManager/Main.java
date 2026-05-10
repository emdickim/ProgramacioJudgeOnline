package a23_02_playerManager;


import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PlayerManager PM = new PlayerManager();
        
        // Add players to the list
        PM.addPlayer(new Player("Kylian", "Mbappé", (byte) 23, 1.78f, 80, 0));
        PM.addPlayer(new Player("Sergi", "Busquets", (byte) 10, 1.89f, 85, 10));
        PM.addPlayer(new Player("Mapi", "Leon", (byte) 26, 1.70f, 60, 5));
        PM.addPlayer(new Player("Leo", "Messi", (byte) 34, 1.70f, 70, 16));
        PM.addPlayer(new Player("Gerard", "Pique", (byte) 35, 1.94f, 84, 30));
        PM.addPlayer(new Player("Alexia", "Putellas", (byte) 28, 1.65f, 58, 0));
        PM.addPlayer(new Player("Alexia", "Putellas", (byte) 28, 1.65f, 60, 22));  // Duplicate - won't be added
        PM.addPlayer(new Player("Gerard", "Pique", (byte) 35, 1.94f, 85, 12));     // Duplicate - won't be added
        
        while (true) {
            System.out.println("MENU\n" +
                    "1. LIST PLAYERS\n" +
                    "2. GET PLAYER BY NAME, SURNAME AND AGE\n" +
                    "3. ADD NEW PLAYER\n" +
                    "4. UPDATE PLAYER BY NAME, SURNAME AND AGE\n" +
                    "5. REMOVE PLAYER BY NAME, SURNAME AND AGE\n" +
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
                    PM.listPlayers();
                }
                case 2 -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter age:");
                    byte age = scanner.nextByte();
                    scanner.nextLine();
                    System.out.println(PM.getPlayerByNameSurnameAndAge(name, surname, age));
                }
                case 3 -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter age:");
                    byte age = scanner.nextByte();
                    System.out.println("Enter height:");
                    float height = scanner.nextFloat();
                    System.out.println("Enter weight:");
                    float weight = scanner.nextFloat();
                    System.out.println("Enter points:");
                    int points = scanner.nextInt();
                    scanner.nextLine();
                    
                    Player newPlayer = new Player(name, surname, age, height, weight, points);
                    System.out.println(PM.addPlayer(newPlayer));
                }
                case 4 -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter age:");
                    byte age = scanner.nextByte();
                    System.out.println("Enter height:");
                    float height = scanner.nextFloat();
                    System.out.println("Enter weight:");
                    float weight = scanner.nextFloat();
                    System.out.println("Enter points:");
                    int points = scanner.nextInt();
                    scanner.nextLine();
                    
                    Player updatedPlayer = new Player(name, surname, age, height, weight, points);
                    System.out.println(PM.updatePlayer(name, surname, age, updatedPlayer));
                }
                case 5 -> {
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    System.out.println("Enter age:");
                    byte age = scanner.nextByte();
                    scanner.nextLine();
                    System.out.println(PM.removePlayer(name, surname, age));
                }
            }
        }
    }
}
