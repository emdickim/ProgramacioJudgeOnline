package a21_03_shopSort;

import java.util.Comparator;

public class Product implements Comparable<Product> {


    private int id;
    private String name;
    private Size size;
    private float price;
    private boolean active;

    private static int idNext = 1;

    public Product(String name, Size size, float price, boolean active) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.active = active;
        this.id = idNext;

        idNext++;
    }



    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id=" + id +
                ", name=" + name  +
                ", size=" + size +
                ", price=" + price +
                ", active=" + active +
                ']';
    }

    
    @Override
    public int compareTo(Product other) {
        int nameCompare = this.name.compareToIgnoreCase(other.getName());
        int sizeCompare = this.size.compareTo(other.getSize());

        //return (nameCompare != 0) ? nameCompare : sizeCompare;
        return Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER).thenComparing(Product::getSize).compare(this, other);

    }

}
