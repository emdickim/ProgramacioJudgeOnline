package a21_03_shopSort;

import java.util.ArrayList;
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
    //Retorna una llista de productes actius (active = true) que contenen en el nom la paraula text (en majúscules o minúscules) i tenen la talla size.
    public List<Product> listProductsNameAndSize(String text, Size size) {
        List<Product> llistaFiltrada = new ArrayList<>();
        for (Product product: products) {
            if (product.isActive() && product.getName().toLowerCase().contains(text) && product.getSize() == size) {
                //System.out.println(product);
                llistaFiltrada.add(product);
            }
        }

        return products.stream().filter(e-> e.isActive() && e.getName().toLowerCase().contains(text) && e.getSize() == size).toList();
    }



    //Retorna la suma dels productes que estan disponibles (active = true).
    public float totalActive() {
        float sum = 0;
        for (Product product: products) {
            if (product.isActive()) {
                sum += product.getPrice();
            }
        }
        return (float) products.stream().filter(Product::isActive).mapToDouble(Product::getPrice).sum();
    }



    //Retorna la suma dels productes que disponibles o no amb una talla determinada.
    public float totalBySize(Size size) {
        float sum = 0;
        for (Product product: products) {
            if (product.getSize() == size) {
                sum += product.getPrice();
            }
        }
        return (float) products.stream().filter(product -> product.getSize() == size).mapToDouble(Product::getPrice).sum();
    }



    //Retorna la mitjana dels preus dels productes disponibles (active = true).
    public float averageActive() {
        //return totalActive() / products.stream().filter(product -> product.isActive()).toList().size();
        return totalActive() / products.stream().filter(Product::isActive).count();
    }

    //Retorna una nova llista ordenada per nom i talla (ignorant majúscules i minúscules). 
    // Implementa la interfície Comparable i sobreescriu el mètode compareTo().
    public List<Product> sortByNameAndSize() {

        return products.stream().sorted().toList();
    }



    //Retorna una nova llista ordenada per preu.
    //Crea un classe ProductPriceComparator que     implementi la interfície 
    // Comparator i sobreescriu el mètode compare().
    public List<Product> sortByPrice() {
        return products.sort(new ProductPriceComparator().toList);
    }

    //Retorna una nova llista ordenada per nom i preu (ignorant majúscules i minúscules). 
    //Crea un classe ProductNameAndPriceComparator que implementi la interfície 
    // Comparator i sobreescriu el mètode compare().
    public List<Product> sortByNameAndPrice() {
        return null;
    }

}
