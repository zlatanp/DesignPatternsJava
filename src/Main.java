import builder.Meal;
import builder.MealBuilder;
import factory.Shape;
import factory.ShapeFactory;
import singleton.SingleObject;

public class Main {

    public static void main(String[] args){
        callFactoryPattern();
        callSingletonPattern();
        callBuilderPattern();
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
}
