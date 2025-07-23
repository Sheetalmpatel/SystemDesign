//Title: You need to extend the functionality of drawing shapes (e.g., Circle, RectangleShape) without changing the original Shape class.
// You can add behaviors like coloring or dotted styles dynamically using decorators.

public class Shape {
    public static void main(String[] args) {
        AllShape circle = new Circle();
        AllShape RectangleShape = new RectangleShape();

        System.out.println("Drawing shapes without decorators:");
        circle.draw();
        RectangleShape.draw();

        System.out.println("\nDrawing shapes with decorators:");
        AllShape redCircle = new RedShapDecorator(circle);
        AllShape redRectangleShape = new RedShapDecorator(RectangleShape);

        redCircle.draw();
        redRectangleShape.draw();
        
    }
}

interface AllShape{
    void draw();
}

class Circle implements AllShape{
    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
} 
class RectangleShape implements AllShape{
        public RectangleShape() {}

    @Override
    public void draw(){
        System.out.println("Drawing Reactangle ");
    }
} 

abstract class ShapeDecorator implements AllShape{
    AllShape allShape;

    public ShapeDecorator(AllShape allShape){
        this.allShape=allShape;
    }
    @Override
    public void draw(){
        allShape.draw();
    }
}

class RedShapDecorator extends ShapeDecorator{
    public RedShapDecorator(AllShape allShape) {
        super(allShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder();
    }
     private void setRedBorder() {
        System.out.println("Border Color: Red");
    }
}