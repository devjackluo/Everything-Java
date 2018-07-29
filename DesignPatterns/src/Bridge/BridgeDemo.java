package Bridge;

import Bridge.Colors.Blue;
import Bridge.Colors.Color;
import Bridge.Colors.Pink;
import Bridge.Colors.Red;
import Bridge.Shapes.Circle;
import Bridge.Shapes.Rectangle;
import Bridge.Shapes.Shape;
import Bridge.Shapes.Square;

public class BridgeDemo {

    public static void main(String[] args){

        //Bridge eliminations the need to create individual classes for each when you could use similarities


        Color blue = new Blue();
        Shape square = new Square(blue);

        Color red = new Red();
        Shape circle = new Circle(red);

        Color pink = new Pink();
        Shape rect = new Rectangle(pink);

        square.applyColor();
        circle.applyColor();
        rect.applyColor();
    }

}
