package structural.bridge;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius, ColorAPI colorAPI) {
        super(colorAPI);
        this.radius = radius;
    }

    public void draw() {
        colorAPI.colorShape(radius);
    }
}