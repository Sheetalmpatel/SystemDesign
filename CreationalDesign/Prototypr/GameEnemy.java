package CreationalDesign.Prototypr;

public class GameEnemy {
    public static void main(String[] args){
        Enemy e1 = new Enemy(1,"xyz");
        Enemy e2 = (Enemy) e1.clone();
        System.out.println(e1.name +" "+e2.name);
        
    }
}

interface  prototype{
    prototype clone();
}

class Enemy implements prototype{
    int id;
    String name;
    Enemy (int id, String name){
        this .id = id;
        this.name=name;
    }

    @Override
    public prototype clone(){
        return new Enemy(id, name);
    }
}