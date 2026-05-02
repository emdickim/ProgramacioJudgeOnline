package a21_03_shopSort;

import java.util.Comparator;

public class ProductNameAndPriceComparator implements Comparator<Product> {
    
    @Override
    public int compare(Product p1, Product p2) {
        return Comparator.comparing(Product::getName).thenComparingDouble(Product::getPrice).compare(p1, p2);
    }
}
