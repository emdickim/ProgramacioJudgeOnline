package a21_01_shopManager;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    public static void main(String[] args) {
        Shop shop = new Shop("Ebay");
        List<Product> llistaProductes = new ArrayList<>();
        
        // Afegir alguns productes per testejar
        llistaProductes.add(new Product("TSHIRT", Size.XXS, 30.25f, true));
        llistaProductes.add(new Product("CAP", Size.XS, 25.75f, true));
        llistaProductes.add(new Product("TROUSERS", Size.S, 30.25f, true));
        llistaProductes.add(new Product("SKIRT", Size.M, 28.25f, true));
        llistaProductes.add(new Product("GLOVES", Size.L, 32.35f, true));
        
        shop.setProducts(llistaProductes);
        
        System.out.println("=== TEST 1: Llista de productes ===");
        shop.listProducts();
        
        System.out.println("\n=== TEST 2: Nombre de productes ===");
        int numProds = shop.numProducts();
        System.out.println("Nombre de productes: " + numProds);
        assert numProds == 5 : "ERROR: Hauria d'haber 5 productes";
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TEST 3: Afegir un producte nou ===");
        Product nouProducte = new Product("JACKET", Size.M, 55.5f, true);
        boolean afegit = shop.addProduct(nouProducte);
        System.out.println("Producte afegit: " + afegit);
        assert afegit : "ERROR: No s'ha pogut afegir el producte";
        assert shop.numProducts() == 6 : "ERROR: Hauria d'haber 6 productes";
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TEST 4: Actualitzar un producte existent ===");
        Product producteActualitzat = new Product("LONG-SHIRT", Size.M, 35.75f, true);
        boolean actualitzat = shop.updateProduct(1, producteActualitzat);
        System.out.println("Producte actualitzat: " + actualitzat);
        assert actualitzat : "ERROR: No s'ha pogut actualitzar el producte";
        System.out.println("Producte ID=1: " + shop.getProducts().get(0));
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TEST 5: Actualitzar un producte NO existent ===");
        boolean actualitzatNoExistent = shop.updateProduct(1000, producteActualitzat);
        System.out.println("Producte actualitzat (no existent): " + actualitzatNoExistent);
        assert !actualitzatNoExistent : "ERROR: No hauria d'actualitzar un producte no existent";
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TEST 6: Eliminar un producte existent ===");
        int numAntes = shop.numProducts();
        boolean eliminat = shop.removeProductById(6);
        System.out.println("Producte eliminat: " + eliminat);
        assert eliminat : "ERROR: No s'ha pogut eliminar el producte";
        assert shop.numProducts() == numAntes - 1 : "ERROR: El nombre de productes hauria de disminuir";
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TEST 7: Eliminar un producte NO existent ===");
        boolean eliminatNoExistent = shop.removeProductById(1000);
        System.out.println("Producte eliminat (no existent): " + eliminatNoExistent);
        assert !eliminatNoExistent : "ERROR: No hauria d'eliminar un producte no existent";
        System.out.println("✓ PASS");
        
        System.out.println("\n=== TOTS ELS TESTS PASSATS! ✓ ===");
    }
}
