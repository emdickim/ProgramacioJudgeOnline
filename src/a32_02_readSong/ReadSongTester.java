package a32_02_readSong;

import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadSongTester {
    
    public static void main(String[] args) {
        ReadSong readSong = new ReadSong();
        
        System.out.println("=== Test 1: Leer archivo válido (test_song.txt) ===");
        try {
            String result = readSong.readTextFile("src/a32_02_readSong/test_song.txt");
            System.out.println(result);
            System.out.println("✓ Test 1 PASSED\n");
        } catch (IOException e) {
            System.out.println("✗ Test 1 FAILED: " + e.getMessage() + "\n");
        }
        
        System.out.println("=== Test 2: Leer archivo válido (song.txt) ===");
        try {
            String result = readSong.readTextFile("src/a32_02_readSong/song.txt");
            System.out.println(result);
            System.out.println("✓ Test 2 PASSED\n");
        } catch (IOException e) {
            System.out.println("✗ Test 2 FAILED: " + e.getMessage() + "\n");
        }
        
        System.out.println("=== Test 3: Archivo no existente ===");
        try {
            String result = readSong.readTextFile("src/a32_02_readSong/nonexistent.txt");
            System.out.println("✗ Test 3 FAILED: Debería haber lanzado FileNotFoundException\n");
        } catch (FileNotFoundException e) {
            System.out.println("✓ Test 3 PASSED: FileNotFoundException capturada con mensaje: " + e.getMessage() + "\n");
        } catch (IOException e) {
            System.out.println("✗ Test 3 FAILED: " + e.getMessage() + "\n");
        }
        
        System.out.println("=== Test 4: IOException (intentar leer directorio en lugar de archivo) ===");
        try {
            String result = readSong.readTextFile("src/a32_02_readSong");
            System.out.println("✗ Test 4 FAILED: Debería haber lanzado IOException\n");
        } catch (IOException e) {
            System.out.println("✓ Test 4 PASSED: IOException capturada con mensaje: " + e.getMessage() + "\n");
        }
    }
}
