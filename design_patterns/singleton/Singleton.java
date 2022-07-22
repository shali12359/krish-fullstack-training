package singleton;

public class Singleton {
    // A STATIC INSTANCE
    private static volatile Singleton uniqueInstance;

    // PRIVATE CONSTRUCTOR TO BLOCK MULTIPLE INSTANCES
    private Singleton() {
        if (uniqueInstance != null) {
            throw new RuntimeException("Use getInstance() method !!");
        }
    }

    // SYNCHRONIZE - OVERCOME MULTIPLE THREADING ISSUES
    public static Singleton getInstance() {
        // LAZY LOADING
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }
}
