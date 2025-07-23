//Title : Amazon Product Decorator Pattern
// Author : sheetal
public class Amazon {
    public static void main(String[] args) {
        Product product= new OnlyProduct();
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.price());
        product = new GiftWrapDecorator(product);
        System.out.println("Description: " + product.getDescription()); 
        System.out.println("Price: " + product.price());

    }
}

interface Product{
    String getDescription();
    double price();
}

class OnlyProduct implements Product{
    @Override
    public String getDescription(){
        return "Only Product";
    }
    @Override
    public double price(){
        return 100;
    }
}

abstract  class ProductDecorator implements Product{
    Product product;

    public ProductDecorator(Product product){
        this.product=product;
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
    @Override
    public double price() { 
        return product.price();
    }
}

class GiftWrapDecorator extends ProductDecorator {
    public GiftWrapDecorator(Product product) {
        super(product);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Gift Wrapped";
    }

    @Override
    public double price() {
        return super.price() + 20; // Adding gift wrap cost
    }
}