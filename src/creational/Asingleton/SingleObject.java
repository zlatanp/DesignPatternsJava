package creational.Asingleton;

// The SingleObject class defines the `getInstance` method that lets
// clients access the same instance of a database connection
// throughout the program
public class SingleObject {

    // The field for storing the creational.singleton instance should be
    // declared static.
    private static SingleObject instance = new SingleObject();

    private SingleObject() {
        // Some initialization code, such as the actual
        // connection to a database server.
        // ...
    }

    // The static method that controls access to the creational.singleton
    // instance.
    public static SingleObject getInstance(){
        if (SingleObject.instance == null)
        // then acquireThreadLock() and then
        // Ensure that the instance hasn't yet been
        // initialized by another thread while this one
        // has been waiting for the lock's release.
        SingleObject.instance = new SingleObject();
        return SingleObject.instance;
    }

    public void showMessage(){
        System.out.println("Hello from Singleton");
    }
}
