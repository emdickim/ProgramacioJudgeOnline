package a32_01_averageFile;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class AverageFile {

    public static double average(String file) throws IOException {
        double suma = 0;
        List<String> llistaDalumnets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String linia;
            while ((linia = br.readLine()) != null) {

                boolean acabaAmbTrueONo = linia.substring(linia.length()-4, linia.length()).equals("true");
                if (acabaAmbTrueONo) {
                    llistaDalumnets.add(linia);
                }
            }
            String[][] alumnePerParts = new String[llistaDalumnets.size()][];
            /*
            * ID;NAME;MARK;ACTIVE
              1;Pep Ros;7,5;true*/



            for (int i = 0; i < llistaDalumnets.size(); i++) {
                alumnePerParts[i] = llistaDalumnets.get(i).split(";");
                suma += Double.parseDouble(alumnePerParts[i][2]);
            }

        }

        if (llistaDalumnets.size() == 0) {
            return 0.00;
        }

        return suma / llistaDalumnets.size();
    }

    public static void main(String[] args) {

        try {
            System.out.printf("Average: %.2f", average("DAMA/src/a32_01_averageFile/AverageFile.csv"));
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

}
