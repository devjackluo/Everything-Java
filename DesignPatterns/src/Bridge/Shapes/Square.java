package Bridge.Shapes;

import Bridge.Colors.Color;

public class Square extends Shape {


    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }

}
