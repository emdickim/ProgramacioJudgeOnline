package a30_07_animeFilmsExceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimeFilms {

    /*
    name;year;points;views;genre
    Your Name;2016;9.5;17000;Drama/Fantasy/Romance
    Weathering With You;AAAA;9.0;18500;Drama/Fantasy/Romance
    */

    public String readTextFile(String inputFile, String errorFile, int year) throws IOException {

        List<String> infoAnimes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        
        String linia;
        String textAnimesCorrectes = br.readLine() + "\n"; // Leer la primera línea (cabecera)
        String textErrors = "";
        while ((linia = br.readLine()) != null) {

            String[] infoAnime = linia.split(";");

            try {
                int anyPelicula = Integer.parseInt(infoAnime[1]);
                if (year == anyPelicula) {
                    textAnimesCorrectes += linia+"\n";
                }
            }   catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                textErrors += linia + "\n";   // ← guardes la línia "per ara"
            }
            
        }
        br.close();
        
        // Escribir output.txt
        writeToFile("C:\\Users\\Kim\\Desktop\\Escola\\Programacio\\DAMA\\src\\a30_07_animeFilmsExceptions\\output.txt", textAnimesCorrectes);
        
        // Escribir errors.txt
        writeToFile(errorFile, textErrors);

        return textAnimesCorrectes + textErrors;
    }


    public void writeToFile(String file, String text) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {  // false para sobrescribir
            bw.write(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimeFilms animeFilms = new AnimeFilms();
        try {
            animeFilms.readTextFile("C:\\Users\\Kim\\Desktop\\Escola\\Programacio\\DAMA\\src\\a30_07_animeFilmsExceptions\\animes.txt", "C:\\Users\\Kim\\Desktop\\Escola\\Programacio\\DAMA\\src\\a30_07_animeFilmsExceptions\\errors.txt", sc.nextInt());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        sc.nextLine();
        sc.close();

    }
    
    

    
}
