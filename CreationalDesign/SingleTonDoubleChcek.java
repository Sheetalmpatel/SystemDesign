package CreationalDesign;

public class SingleTonDoubleChcek {
    public static void main(String[] args) {
        singleTon s= singleTon.getInstance();
        singleTon s2= singleTon.getInstance();// no  print same instance
        
    }
}

class singleTon {
    static volatile singleTon obj;

    public singleTon() {
        System.out.println("Instance created");
    }

    static singleTon getInstance() {
        if (obj == null) {
            synchronized (singleTon.class) {
                if (obj == null) {
                    obj = new singleTon();
                }
            }
        }
        return obj;
    }

}
