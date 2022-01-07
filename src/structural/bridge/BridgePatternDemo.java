package structural.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, new RedColorAPI());
        Shape blueCircle = new Circle(10, new BlueColorAPI());
        Shape redSquare = new Square(10, new RedColorAPI());
        Shape blueSquare = new Square(1, new BlueColorAPI());

        redCircle.draw();
        blueCircle.draw();
        redSquare.draw();
        blueSquare.draw();
    }
}
