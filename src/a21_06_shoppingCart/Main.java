package a21_06_shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shop shop = new Shop("Ebay");
        Cart cart = new Cart();
        List<Product> llistaProductes = new ArrayList<>();
        afegirProductes(llistaProductes);
        shop.setProducts(llistaProductes);
        while (true) {
            System.out.println("1. LIST PRODUCTS (SHOP)\n" +
                    "2. ADD PRODUCT TO CART\n" +
                    "3. LIST CART\n" +
                    "4. REMOVE PRODUCT FROM CART\n" +
                    "5. CART TOTAL\n" +
                    "6. CART TAX (IVA 21%)\n" +
                    "7. CLEAR CART\n" +
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
                    shop.listProducts();
                }
                case 2 -> {
                    System.out.println("Enter product ID to add:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    Product product = shop.getProductById(productId);
                    if (product == null) {
                        
                        System.out.println("Product not found");
                    } else {
                        cart.addProduct(product);
                        System.out.println("Product added to cart");
                    }

                }
                case 3 -> {
                    cart.showCart();
                }
                case 4 -> {
                    System.out.println("Enter product ID to remove:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println((cart.removeProduct(productId)) ? "Product removed from cart":"This id is not in the cart");
                }
                case 5 -> System.out.printf("Total: %.2f%n", cart.getTotal()); 
                case 6 -> System.out.printf("Tax: %.2f%n", cart.getTax()); 
                case 7 -> {
                    cart.clearCart();
                    System.out.println("Cart cleared");
                }
            }
        }
    }

    
    private static Size whatSize(int nextInt) {
        return switch (nextInt) {
            case 1 -> Size.XXS;
            case 2 -> Size.XS;
            case 3 -> Size.S;
            case 4 -> Size.M;
            case 5 -> Size.L;
            case 6 -> Size.XL;
            case 7 -> Size.XXL;
            default -> Size.M;
        };
    }

    private static void afegirProductes(List<Product> llistaProductes) {
        llistaProductes.add(new Product("TSHIRT", Size.XXS, 30.25f, true));
        llistaProductes.add(new Product("CAP", Size.XS, 25.75f, true));
        llistaProductes.add(new Product("TROUSERS", Size.S, 30.25f, true));
        llistaProductes.add(new Product("SKIRT", Size.M, 28.25f, true));
        llistaProductes.add(new Product("GLOVES", Size.L, 32.35f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XL, 23.79f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XXL, 35.25f, true));
        llistaProductes.add(new Product("JACKET", Size.XL, 59.97f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 29.95f, true));
        llistaProductes.add(new Product("LONG-SHIRT", Size.XS, 20.56f, true));
        llistaProductes.add(new Product("TANK-TSHIRT", Size.XL, 16.55f, true));
        llistaProductes.add(new Product("TSHIRT", Size.M, 29.15f, true));
        llistaProductes.add(new Product("TANK-TSHIRT", Size.XXL, 24.45f, true));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 32.50f, true));
        llistaProductes.add(new Product("LONG-SHIRT", Size.XS, 32.70f, false));
        llistaProductes.add(new Product("SHIRT", Size.XS, 34.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 33.25f, false));
        llistaProductes.add(new Product("SLEEVELESS-SHIRT", Size.XS, 32.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.XS, 28.50f, false));
        llistaProductes.add(new Product("TSHIRT", Size.S, 29.50f, false));
    }

}
