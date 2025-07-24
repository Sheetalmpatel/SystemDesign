//Title : simple code of LaptopDemo

package CreationalDesign;
public class BuilderLaptop {
    public static void main(String[] args) {
        LaptopDemo l1= new LaptopDemo.Builder("i7",100).setOs("window").build();
        l1.show();

    }
}

class LaptopDemo{
    String processor;
    int ram;
    int storage;
    String os;

    public LaptopDemo(Builder builder) {
        this.processor=builder.processor;
        this.ram = builder.ram;
        this.storage= builder.storage;
        this.os = builder.os;
    }
    static class Builder{
        String processor;
    int ram;
    int storage;
    String os;

        public Builder(String processor, int storage) {
            this.processor=processor;
            this.storage=storage;
        }

        Builder setOs(String os){
            this.os = os;
            return this;
        }
        Builder setRam(int ram){
            this.ram = ram;
            return this;
        }
        LaptopDemo build(){
            return new LaptopDemo(this);
        }

       

    }
    public void show(){
            System.out.println("processor:"+processor+"ram:"+ram+"storage:"+storage);
        }
    
}