package Bridge.Shapes;

import Bridge.Colors.Color;

public abstract class Shape {

    protected Color color;

    public Shape(Color color){
        this.color = color;
    }

    abstract public void applyColor();

}
