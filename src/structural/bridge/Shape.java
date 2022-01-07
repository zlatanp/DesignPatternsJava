package structural.bridge;

public abstract class Shape {
    protected ColorAPI colorAPI;

    protected Shape(ColorAPI colorAPI){
        this.colorAPI = colorAPI;
    }
    public abstract void draw();
}
