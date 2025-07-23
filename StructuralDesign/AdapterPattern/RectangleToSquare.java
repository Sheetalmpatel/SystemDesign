//Title : Rectangle to Square Adapter Pattern
// Author : sheetal

public class RectangleToSquare {
    public static void main(String[] args) {
        Rectangle re= new Rectangle(20,30);
        SquareAdapter sa = new SquareAdapter(re);
        sa.setSide(10);
        System.out.println("Initial side: " + sa.getArea());

    }
}
class Rectangle{
    int width;
    int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() {
        return width * height;
    }
    
}
interface  Square {
    int getSide();
    void setSide(int width);
    int getArea();
}   

class SquareAdapter implements Square{

    Rectangle re;

    public SquareAdapter(Rectangle re) {
        this.re=re;
    }
    @Override
    public int getSide(){
        return re.getWidth();
    }
    @Override
    public void setSide(int height) {
        re.setHeight(height);
        re.setWidth(height);
    }
    @Override
    public int getArea() {
        return re.getArea();
    }
    
}
