//Title : Vehicle factory 
package CreationalDesign;

public class AbstractFactoryPattern {
    public static void  main(String[] args){
        Producer p= new Producer();
        //choose type 
        vehicleFactory v= p.getFactoryInstance("petrol");
        if(v!=null){
            vehicle vehicle= v.getVehicleInstance(100);
            vehicle.type();
            System.out.println("speed:"+ vehicle.speed());
        }

    }
}

interface  vehicle{
    int speed();
    void type();

}

class petrolBike implements  vehicle{
    int price;
    public petrolBike(int price) {
        this.price = price;
    }

    @Override
    public int speed(){
        return 100;
    }
    @Override
    public void type(){
        System.out.println("petrolbike");
    }


    
}
class electricalBike implements  vehicle{
    int price;
    public electricalBike(int price) {
        this.price = price;
    }

    @Override
    public int speed(){
        return 100;
    }
    @Override
    public void type(){
        System.out.println("petrolbike");
    }
  
}

interface  vehicleFactory{
    vehicle getVehicleInstance(int price);
}

class petrolFactory implements  vehicleFactory{
    @Override
    public vehicle getVehicleInstance(int price){
        return new petrolBike(price);
    }
    
}
class electricalFactory implements  vehicleFactory{
    @Override
    public vehicle getVehicleInstance(int price){
        return new electricalBike(price);
    }
    
}

class Producer{
    vehicleFactory getFactoryInstance(String fuletype){
        if(fuletype.equalsIgnoreCase("petrol")){
            return new petrolFactory();
        }
        else if(fuletype.equalsIgnoreCase("electrical")){
            return new electricalFactory();
        }
        return null;
    }
}