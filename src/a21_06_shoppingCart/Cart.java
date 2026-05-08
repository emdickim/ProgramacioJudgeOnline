package a21_06_shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    public static final float TAX = 21.0f;
    private List<Product> cartProducts;
    public Cart () {
        cartProducts = new ArrayList<>();
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }

    //Afegeix un producte a la cistella de compra si aquest està actiu o no és null.
    // Retorna true si l'afegeix correctament, false en cas contrari.
    public boolean addProduct(Product product) {
        if (product != null && product.isActive()) {
            return cartProducts.add(product);
        }

        return false;
    }

    //Elimina els productes de la cistella que tinguin el id especificat.
    // Si la cistella conté més d'un producte amb aquest id, s'han d'eliminar tots.
    // Retorna true si el producte és eliminat, false en cas contrari.
    //Pista: pots utilitzar el mètode removeIf() que permet esborrar més d'un element indicant la condició amb una expressió lambda.
    public boolean removeProduct(int id) {
       return cartProducts.removeIf(product -> product.getId() == id);
    }


    //Retorna la llista de productes de la cistella que contenen el text especificat en el nom,
    // ignorant les majúscules i minúscules.
    public List<Product> searchByName(String text) {
        return cartProducts.stream()
                .filter(product -> product.getName().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    //Mostra els productes de la cistella per consola. Si la cistella està buida, mostra "Cart is empty".
    public void showCart() {
        if (cartProducts.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        cartProducts.forEach(System.out::println);
    }

    //Retorna el total del preu dels productes de la cistella.
    public float getTotal() {
        return (float) cartProducts.stream().mapToDouble(Product::getPrice).sum();
    }

    //Calcula i retorna l'IVA (21%) del total de la cistella (els preus dels productes contenen el IVA).
    public float getTax() {
        return getTotal() * TAX / (100 + TAX);
    }

    //Buida la cistella de compra.
    public void clearCart() {
        cartProducts.clear();
    }

}
