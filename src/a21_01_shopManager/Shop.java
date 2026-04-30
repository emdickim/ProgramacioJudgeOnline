package a21_01_shopManager;

import java.util.List;

public class Shop {

    private String name;
    private List<Product> products;

    public void listProducts() {
        products.stream().forEach(System.out::println);
    }
    

    public Shop(String name) {
        this.name = name;

        products = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public int numProducts() {
        return products.size();
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean updateProduct(int id, Product product) {
        if (numProducts() < id || id <= 0) return false;


        Product producteAActualitzar = products.get(id-1);
        producteAActualitzar.setName(product.getName());
        producteAActualitzar.setActive(product.isActive());
        producteAActualitzar.setPrice(product.getPrice());
        producteAActualitzar.setSize(product.getSize());

        return true;
    }

    public boolean removeProductById(int id) {
        if (numProducts() < id || id <= 0) return false;

        products.remove(id-1);
        return true;
    }
}
