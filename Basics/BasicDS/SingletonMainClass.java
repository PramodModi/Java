package BasicDS;

public class SingletonMainClass {
    public static void main(String[] args) {
        SingletonClass instance = SingletonClass.getInstance();
        instance.setId(1);
        instance.setName("Pramod");
        System.out.println(instance.toString());

        //Thread safe Singleton class
        SingletonThreadSafe threadSafeInstance = new SingletonThreadSafe();
        threadSafeInstance.setId(2);
        threadSafeInstance.setName("Ritu");
        System.out.println(threadSafeInstance.toString());
    }
}
