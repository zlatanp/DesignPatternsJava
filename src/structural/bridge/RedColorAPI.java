package structural.bridge;

public class RedColorAPI implements ColorAPI {
    @Override
    public void colorShape(int radius) {
        System.out.println("Coloring Shape[ colorAPI: red, radius: " + radius + "]");
    }
}
