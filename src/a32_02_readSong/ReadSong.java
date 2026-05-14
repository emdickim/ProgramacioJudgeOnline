package a32_02_readSong;

import java.io.*;

public class ReadSong {
    
    
    public String readTextFile(String file) throws IOException {

       String song = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String linia;
            int contador = 0;

            while ((linia = br.readLine()) != null) {
                song += String.format("%d: %s%n", ++contador, linia);
            }

            br.close();
            /*ES POT FER AMB UN SISTEMOUTPRIN ENCONTRES DE TROWS, LAVVORS PODRIA TEURE EL TROWES DEL MAIN I DEL METODE
            
            ADEMES TAMBE ES PRODRIA TREURE EL TRY CATCH DEL MAIN LLAVORS :D*/
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            throw new IOException("Error reading file");
        } 

        return song;
    }

    public static void main(String[] args) throws IOException {
    
        ReadSong readSong = new ReadSong();
        try {
            readSong.readTextFile("song.txt");
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
            
    }

}
