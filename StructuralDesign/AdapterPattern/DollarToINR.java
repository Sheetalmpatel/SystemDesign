//Title :- Adpater Pattern Design --> convert Dollar to INR

public class DollarToINR {
    public static void main(String[] args) {
        Dollar dollar = new Dollar();
        INRpriceAdapter ia= new INRpriceAdapter(dollar);
        System.out.println(ia.getINRprice());
    }
}
class Dollar{
    double getPrice(){
        return 2;
    }
}

interface INRprice{
    double getINRprice();
} 
class INRpriceAdapter implements INRprice{
    Dollar dollar;
    INRpriceAdapter(Dollar dollar){
        this.dollar=dollar;
    }
    @Override 
    public double getINRprice(){
        return dollar.getPrice() * 80;
    }
}




