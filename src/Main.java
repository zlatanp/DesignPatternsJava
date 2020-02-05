import adapter.AudioPlayer;
import builder.Meal;
import builder.MealBuilder;
import decorator.Circle;
import decorator.Rectangle;
import decorator.RedShapeDecorator;
import factory.Shape;
import factory.ShapeFactory;
import responsibility.AbstractLogger;
import responsibility.ConsoleLogger;
import responsibility.ErrorLogger;
import responsibility.FileLogger;
import singleton.SingleObject;

public class Main {

    public static void main(String[] args){
        System.out.println("------------------FACTORY PATTERN------------------");
        callFactoryPattern();
        System.out.println("------------------SINGLETON PATTERN------------------");
        callSingletonPattern();
        System.out.println("------------------BUILDER PATTERN------------------");
        callBuilderPattern();
        System.out.println("------------------ADAPTER PATTERN------------------");
        callAdapterPattern();
        System.out.println("------------------DECORATOR PATTERN------------------");
        callDecoratorPattern();
        System.out.println("------------------CHAIN OF RESPONSABILITY PATTERN------------------");
        callResponsabilityChainPattern();
    }

    private static void callFactoryPattern(){
        ShapeFactory shapeFactory = new ShapeFactory();
        
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }

    private static void callSingletonPattern(){
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }

    private static void callBuilderPattern(){
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal: ");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Veg Meal: ");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
    }

    private static void callAdapterPattern(){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

    private static void callDecoratorPattern(){
        decorator.Shape circle = new Circle();
        decorator.Shape redCirle = new RedShapeDecorator(new Circle());
        decorator.Shape redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();
        redCirle.draw();
        redRectangle.draw();
    }

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    private static void callResponsabilityChainPattern(){
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error level information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information");
    }
}
