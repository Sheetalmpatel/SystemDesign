// Title : Coffee Decorator Pattern
// Author : sheetal
public class Coffee {
    public static void main(String[] args) {
        BasicCoffee coffee= new simpleCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Price: " + coffee.price());

        coffee = new MilkDecorator(coffee);
        System.out.println("Description: " + coffee.getDescription());
                System.out.println("Price: " + coffee.price());


        coffee = new SugarDecorator(coffee);
        System.out.println("Description: " + coffee.getDescription());
                System.out.println("Price: " + coffee.price());

    }
}
interface  BasicCoffee{
    String getDescription();
    double price();
}

class simpleCoffee implements BasicCoffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    @Override
    public double price(){
        return 100;
    }
}
abstract  class coffeeDecorator implements  BasicCoffee{
    BasicCoffee basicCoffee;
    public coffeeDecorator(BasicCoffee basicCoffee){
        this.basicCoffee=basicCoffee;
    }

    @Override
    public String getDescription(){
        return basicCoffee.getDescription();
    }
    @Override
    public double price(){
        return basicCoffee.price();
    }

}

class MilkDecorator extends coffeeDecorator{
    public MilkDecorator(BasicCoffee basicCoffee){
        super(basicCoffee);
    }

    public String getDescription(){
        return super.getDescription()+"milk";
    }
    public double price(){
        return super.price()+20;
    }
}
class SugarDecorator extends coffeeDecorator{
    public SugarDecorator(BasicCoffee basicCoffee){
        super(basicCoffee);
    }

    public String getDescription(){
        return super.getDescription()+"sugar";
    }
    public double price(){
        return super.price()+10;
    }
}