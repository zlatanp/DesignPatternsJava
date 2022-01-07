package structural.bridge;

public class BlueColorAPI implements ColorAPI {
    @Override
    public void colorShape(int radius) {
        System.out.println("Coloring Shape[ colorAPI: blue, radius: " + radius + "]");
    }
}
