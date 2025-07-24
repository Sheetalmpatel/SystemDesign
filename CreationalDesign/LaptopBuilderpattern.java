//Title: Laptop Builder pattern using builder director

// package CreationalDesign;

public class LaptopBuilderpattern {
     public static void main(String[] args) {
        LaptopDirector director = new LaptopDirector();

        //  Gaming Laptop
        Laptop gamingLaptop = director.constructLaptop(new GamingLaptopBuilder());
        System.out.println("🎮 Gaming Laptop Specs:");
        gamingLaptop.showSpecs();

        //  Normal Laptop
        Laptop normalLaptop = director.constructLaptop(new NormalLaptopBuilder());
        System.out.println("💻 Normal Laptop Specs:");
        normalLaptop.showSpecs();
    }

}
 class Laptop {
    String processor;
    String ram;
    String storage;
    String graphicsCard;
    String os;

    public Laptop(String processor, String ram, String storage, String graphicsCard, String os) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.os = os;
    }

    public void showSpecs() {
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("OS: " + os);
        System.out.println("----------------------------");
    }
}

 abstract class LaptopBuilder {
    protected String processor;
    protected String ram = "16GB";              // common default
    protected String storage = "512GB SSD";     // common default
    protected String graphicsCard;
    protected String os;

    public LaptopBuilder buildProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public LaptopBuilder buildGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public abstract LaptopBuilder installOS();
    public Laptop build() {
        return new Laptop(processor, ram, storage, graphicsCard, os);
    }
    
}

 class GamingLaptopBuilder extends LaptopBuilder {
    @Override 
public  LaptopBuilder installOS(){
	this.os = "Windows 11 Pro (Gaming Optimized)";
        return this;

}
}

class NormalLaptopBuilder extends LaptopBuilder {
    @Override
    public LaptopBuilder installOS() {
        this.os = "Windows 10 Home";
        return this;
    }
}


class LaptopDirector {

    public Laptop constructLaptop(LaptopBuilder builder) {
        if (builder instanceof GamingLaptopBuilder) {
            return createGamingLaptop((GamingLaptopBuilder) builder);
        } else if (builder instanceof NormalLaptopBuilder) {
            return createNormalLaptop((NormalLaptopBuilder) builder);
        } else {
            throw new IllegalArgumentException("Unknown Laptop Type");
        }
    }

    private Laptop createGamingLaptop(GamingLaptopBuilder builder) {
        return builder
                .buildProcessor("Intel i9")
                .buildGraphicsCard("NVIDIA RTX 4080")
                .installOS()
                .build();
    }

    private Laptop createNormalLaptop(NormalLaptopBuilder builder) {
        return builder
                .buildProcessor("Intel i5")
                .buildGraphicsCard("Integrated Graphics")
                .installOS()
                .build();
    }
}




