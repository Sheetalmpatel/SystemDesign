package CreationalDesign;

public class FactoryPattern {
    public static void main(String[] args) {
        AnimalFactory factory= new  AnimalFactory();
       Animal animal= factory.getAnimal("dog");
        animal.speak();
    }
}

interface  Animal{
    void speak();
}

class Dog implements  Animal{
    @Override
    public void speak(){
        System.out.println("dog voice");
    }
}
class Cat implements  Animal{
    @Override
    public void speak(){
        System.out.println("cat voice");
    }
}

class AnimalFactory{
    Animal getAnimal(String name){
        if(name.equalsIgnoreCase("dog")){
            return  new Dog();
        }
        else if(name.equalsIgnoreCase("cat")){
            return new Cat();
        }
        return null;
    }


}
