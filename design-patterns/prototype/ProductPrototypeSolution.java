abstract class ProductPrototype {
    abstract ProductPrototype makeClone();
    abstract void display();
    abstract void update(String name);
}

class Product extends ProductPrototype {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public ProductPrototype makeClone() {
        return new Product(this.name, this.price);
    } 

    @Override
    public void display() {
        System.out.println("Product name: " + this.name + ", Product price: " + this.price);
    }

    @Override
    public void update(String name) {
        this.name = name;
    }
}

public class ProductPrototypeSolution {
    public static void main(String[] args) {
        ProductPrototype prototype = new Product("Dot&Key Vitamin C Sunscreen", 399.90);
        System.out.println("Original Product");
        prototype.display();

        ProductPrototype prototype2 = prototype.makeClone();
        prototype2.update("Dot&Key Barrier Repair Sunscreen");
        System.out.println("Cloned Product");
        prototype2.display();
    }
}