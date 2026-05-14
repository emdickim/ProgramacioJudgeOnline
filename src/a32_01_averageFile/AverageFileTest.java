package a32_01_averageFile;

import java.io.IOException;

public class AverageFileTest {

    public static void main(String[] args) {
        System.out.println("=== Pruebas de AverageFile ===\n");
        
        // Prueba 1: Archivo válido
        testAverageWithValidFile();
        
        // Prueba 2: Archivo no existe
        testAverageWithNonExistentFile();
        
        // Prueba 3: Ruta vacía
        testAverageWithEmptyPath();
    }
    
    public static void testAverageWithValidFile() {
        System.out.println("Prueba 1: Archivo válido");
        try {
            double result = AverageFile.average("DAMA/src/a32_01_averageFile/AverageFile.csv");
            if (result > 0) {
                System.out.println("✓ PASÓ - Promedio: " + result);
            } else {
                System.out.println("✗ FALLÓ - El promedio debería ser mayor que 0");
            }
        } catch (Exception e) {
            System.out.println("✗ FALLÓ - Excepción: " + e.getMessage());
        }
        System.out.println();
    }

    public static void testAverageWithNonExistentFile() {
        System.out.println("Prueba 2: Archivo no existe");
        try {
            AverageFile.average("archivo_no_existe.csv");
            System.out.println("✗ FALLÓ - Debería lanzar IOException");
        } catch (IOException e) {
            System.out.println("✓ PASÓ - IOException lanzada correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ FALLÓ - Tipo de excepción incorrecto: " + e.getClass().getName());
        }
        System.out.println();
    }

    public static void testAverageWithEmptyPath() {
        System.out.println("Prueba 3: Ruta vacía");
        try {
            AverageFile.average("");
            System.out.println("✗ FALLÓ - Debería lanzar IOException");
        } catch (IOException e) {
            System.out.println("✓ PASÓ - IOException lanzada correctamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ FALLÓ - Tipo de excepción incorrecto: " + e.getClass().getName());
        }
        System.out.println();
    }
}
