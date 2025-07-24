//Title : Ecommerce Cart using Composite Pattern

package StructuralDesign.CompositePattern;
import java.util.ArrayList;
import java.util.List;

public class EcomCart {
    public static void main(String[] args) {
        cartItem laptop = new product("Laptop", 1000);
        cartItem phone = new product("Phone", 500);
        productBundle gadget = new productBundle("Gadget Bundle");
        cartItem headphones = new product("Headphones", 100);
        cartItem charger = new product("Charger", 50);
        gadget.addItem(headphones);
        gadget.addItem(charger);
        productBundle electronics = new productBundle("Electronics Bundle");
        electronics.addItem(laptop);
        electronics.addItem(gadget);

        electronics.showDetails(" ");
        System.out.println("Total Price: " + electronics.getPrice());
    }

}

interface  cartItem{
    
    double getPrice();
    void showDetails(String indent);
}

class product implements cartItem{
    String name;
    double price;
    product (String name, double price){
        this.name=name;
        this.price=price;
    }
    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public void showDetails(String indent){
        System.out.println(indent + "product "+ name +" price:"+ price);
    }
}

class productBundle implements cartItem{
    String name ;
    List<cartItem> cart = new ArrayList<>();
    productBundle (String name){
        this.name= name;
    }
    
    public void addItem(cartItem item){
        cart.add(item);
    }
    @Override 
    
    public void showDetails(String indent){
        System.out.println(indent +"bundle"+ name);
        for(cartItem item : cart){
            item.showDetails(indent + " ");
        }
    }
    
    @Override
    public double getPrice(){
        double price=0;
        
        for(cartItem item : cart){
            price += item.getPrice();
        }
        return price;
    }
    
}