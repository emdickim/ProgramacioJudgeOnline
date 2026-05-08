package a21_06_shoppingCart;

import java.util.List;

public class TestShoppingCart {
    public static void main(String[] args) {
        System.out.println("=== INICI TEST SHOPPING CART ===\n");
        
        // Crear botiga
        Shop shop = new Shop("Botiga Test");
        
        // Afegir productes inicials
        shop.addProduct(new Product("TSHIRT", Size.XXS, 30.25f, true));
        shop.addProduct(new Product("CAP", Size.XS, 25.75f, true));
        shop.addProduct(new Product("TROUSERS", Size.S, 30.25f, true));
        shop.addProduct(new Product("SKIRT", Size.M, 28.25f, true));
        shop.addProduct(new Product("GLOVES", Size.L, 32.35f, true));
        shop.addProduct(new Product("TSHIRT", Size.XL, 23.79f, true));
        shop.addProduct(new Product("TSHIRT", Size.XXL, 35.25f, true));
        shop.addProduct(new Product("JACKET", Size.XL, 59.97f, true));
        shop.addProduct(new Product("TSHIRT", Size.XS, 29.95f, true));
        shop.addProduct(new Product("LONG-SHIRT", Size.XS, 20.56f, true));
        shop.addProduct(new Product("TANK-TSHIRT", Size.XL, 16.55f, true));
        shop.addProduct(new Product("TSHIRT", Size.M, 29.15f, true));
        shop.addProduct(new Product("TANK-TSHIRT", Size.XXL, 24.45f, true));
        shop.addProduct(new Product("TSHIRT", Size.XS, 32.50f, true));
        shop.addProduct(new Product("LONG-SHIRT", Size.XS, 32.70f, false));
        shop.addProduct(new Product("SHIRT", Size.XS, 34.50f, false));
        shop.addProduct(new Product("TSHIRT", Size.XS, 33.25f, false));
        shop.addProduct(new Product("SLEEVELESS-SHIRT", Size.XS, 32.50f, false));
        shop.addProduct(new Product("TSHIRT", Size.XS, 28.50f, false));
        shop.addProduct(new Product("TSHIRT", Size.S, 29.50f, false));
        
        // TEST 1: Shop addProduct
        System.out.println("TEST 1 - Shop addProduct: " + (shop.addProduct(new Product("TEST", Size.M, 10.0f, true)) ? "OK" : "ERROR"));
        
        // Crear cistella
        Cart cart = new Cart();
        
        // TEST 2: Cart addProduct amb productes actius
        cart.addProduct(shop.getProductById(1));
        cart.addProduct(shop.getProductById(1));
        cart.addProduct(shop.getProductById(1));
        cart.addProduct(shop.getProductById(2));
        cart.addProduct(shop.getProductById(2));
        cart.addProduct(shop.getProductById(4));
        cart.addProduct(shop.getProductById(5));
        System.out.println("TEST 2 - Cart addProduct (actius): OK");
        
        // TEST 3: Cart addProduct amb producte inactiu
        boolean result = cart.addProduct(shop.getProductById(20));
        System.out.println("TEST 3 - Cart addProduct (inactiu): " + (result == false ? "OK" : "ERROR"));
        
        // TEST 4: Cart removeProduct existent
        result = cart.removeProduct(1);
        System.out.println("TEST 4 - Cart removeProduct (existent): " + (result == true ? "OK" : "ERROR"));
        
        // TEST 5: Cart removeProduct no existent
        result = cart.removeProduct(1000);
        System.out.println("TEST 5 - Cart removeProduct (no existent): " + (result == false ? "OK" : "ERROR"));
        
        // TEST 6: Cart getTotal
        Cart cartTotal = new Cart();
        cartTotal.addProduct(shop.getProductById(2));
        cartTotal.addProduct(shop.getProductById(2));
        cartTotal.addProduct(shop.getProductById(4));
        cartTotal.addProduct(shop.getProductById(5));
        float total = cartTotal.getTotal();
        System.out.println("TEST 6 - Cart getTotal: " + (Math.abs(total - 112.10f) < 0.01f ? "OK" : "ERROR (got: " + total + ")"));
        
        // TEST 7: Cart getTax
        float tax = cartTotal.getTax();
        System.out.println("TEST 7 - Cart getTax: " + (Math.abs(tax - 23.541f) < 0.01f ? "OK" : "ERROR (got: " + tax + ")"));
        
        // TEST 8: Cart searchByName
        Cart cartSearch = new Cart();
        cartSearch.addProduct(shop.getProductById(1));
        cartSearch.addProduct(shop.getProductById(1));
        cartSearch.addProduct(shop.getProductById(2));
        cartSearch.addProduct(shop.getProductById(4));
        cartSearch.addProduct(shop.getProductById(5));
        cartSearch.addProduct(shop.getProductById(6));
        cartSearch.addProduct(shop.getProductById(7));
        cartSearch.addProduct(shop.getProductById(10));
        List<Product> searchResult = cartSearch.searchByName("shirt");
        System.out.println("TEST 8 - Cart searchByName 'shirt': " + (searchResult.size() == 5 ? "OK" : "ERROR (got: " + searchResult.size() + ")"));
        
        // TEST 9: Cart searchByName text no existent
        searchResult = cartSearch.searchByName("xxx");
        System.out.println("TEST 9 - Cart searchByName 'xxx': " + (searchResult.isEmpty() ? "OK" : "ERROR"));
        
        // TEST 10: Shop getProductById existent
        Product p = shop.getProductById(1);
        System.out.println("TEST 10 - Shop getProductById (existent): " + (p != null ? "OK" : "ERROR"));
        
        // TEST 11: Shop getProductById no existent
        p = shop.getProductById(1000);
        System.out.println("TEST 11 - Shop getProductById (no existent): " + (p == null ? "OK" : "ERROR"));
        
        // TEST 12: Cart clearCart
        cartSearch.clearCart();
        System.out.println("TEST 12 - Cart clearCart: " + (cartSearch.searchByName("shirt").isEmpty() ? "OK" : "ERROR"));
        
        System.out.println("\n=== FI TEST ===");
    }
}