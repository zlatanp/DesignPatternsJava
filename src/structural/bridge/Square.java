package structural.bridge;

public class Square extends Shape {
    private int x;

    public Square(int x, ColorAPI colorAPI) {
        super(colorAPI);
        this.x = x;
    }

    public void draw() {
        colorAPI.colorShape(x);
    }
}