package a30_07_animeFilmsExceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeFilms {

    /*
    name;year;points;views;genre
    Your Name;2016;9.5;17000;Drama/Fantasy/Romance
    Weathering With You;AAAA;9.0;18500;Drama/Fantasy/Romance
    */

    public String readTextFile(String inputFile, String errorFile, int year) throws IOException {

        List<String> infoAnimes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        br.readLine();
        String linia;

        while ((linia = br.readLine()) != null) {

            //infoAnimes.add(linia);
            
        }

        return "";
    }


    public void writeToFile(String file, String text) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimeFilms animeFilms = new AnimeFilms();

        animeFilms.readTextFile("animes.txt", "output.txt", sc.nextInt());

        sc.nextLine();
        sc.close();

    }
    
    

    
}
