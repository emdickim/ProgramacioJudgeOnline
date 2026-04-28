package a19_07_taskManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    //Afegeix una tasca al final de la llista si aquesta no existeix (ignorant majúscules o minúscules).
    // Retorna true si la tasca s'afegeix a la llista, false en cas contrari.

    public boolean addTask(List<String> tasks, String task) {

        if (tasks.stream().anyMatch(p -> p.equalsIgnoreCase(task))) {
            System.out.println("Task not addeded");
            return false;
        }

        System.out.println("Task added");
        return tasks.add(task);
    }


    //Afegeix una tasca a la posició indicada si aquesta no existeix (ignorant majúscules i minúscules) i si la posició existeix.
    // Retorna true si la tasca s'afegeix a la llista, false en cas contrari.

    public boolean addTaskAtPosition(List<String> tasks, String task, int index) {

        if(tasks.size() <= index) {
            System.out.println("Task not added");
            return false;
        }

        for (String tasca : tasks) {
            if (tasca.equalsIgnoreCase(task)) {
                System.out.println("Task not added");
                return false;
            }
        }

        tasks.add(index, task);
        System.out.println("Task added");
        return true;
    }


    //Elimina una tasca si aquesta existeix (ignorant majúscules i minúscules).
    // Retorna true si la tasca és elimina, false en cas contrari.

    public boolean removeTaskByName(List<String> tasks, String task){
//        for (String tasca : tasks) {
//            if (tasca.equalsIgnoreCase(task)) {
//
//                return tasks.remove(task);
//            }
//        }
        if (tasks.removeIf(t -> t.equalsIgnoreCase(task))) {
            return true;
        }
        System.out.println("Task not found");
        return false;
    }


    //Elimina l'etiqueta de la posició indicada (si aquesta posició existeix).
    // Retorna la tasca que conté la posició si la tasca és eliminada, null en cas contrari.

    public String removeTaskByIndex(List<String> tasks, int index) {
        if (tasks.size() <= index) {
            return null;
        }

        return tasks.remove(index);}

    public static void main(String[] args) {

        TaskManager p = new TaskManager();

        String[] titols = {"Buy groceries",
                            "Finish Java homework",
                            "Send email to client",
                            "Clean the house",
                            "Prepare presentation",
                            "Go to the gym",
                            "Read a book",
                            "Fix bug #231",
                            "Update documentation",
                            "Plan weekend trip"};

        List<String> llistaDeTasques = new ArrayList<>();

        for (int i = 0; i < titols.length; i++) {
            llistaDeTasques.add(titols[i]);
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose option:");
            System.out.println("1. Show all tasks");
            System.out.println("2. Add task at the end");
            System.out.println("3. Add task at position");
            System.out.println("4. Remove task by name");
            System.out.println("5. Remove task by index");
            System.out.println("0. Exit");

            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio) {
                case 0 -> {
                    return;
                }
                case 1 -> System.out.println(llistaDeTasques);
                case 2 -> {
                    p.addTask(llistaDeTasques, sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter task name:");
                    String name = sc.nextLine();
                    System.out.println("Enter position:");
                    p.addTaskAtPosition(llistaDeTasques, name, sc.nextInt());
                    sc.nextLine();
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("Enter task name:");
                    String name = sc.nextLine();
                    p.removeTaskByName(llistaDeTasques, name);
                }
                case 5 -> {
                    System.out.println("Enter task index:");
                    System.out.println("Task removed: " + p.removeTaskByIndex(llistaDeTasques, sc.nextInt()));
                    sc.nextLine();
                    System.out.println();
                }
            }
        }


    }
}
