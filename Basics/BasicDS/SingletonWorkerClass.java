package BasicDS;

public class SingletonWorkerClass extends Thread {
    int id;
    String name;

    public SingletonWorkerClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public void run(){
        SingletonThreadSafe singleInstance = SingletonThreadSafe.getInstance();
        //If you uncomment below line, singleton class without thread safe will be instantiated.
        //multiple threads may create more than one instance. Re-run the "SingletonThreadSafeMainClass" to verify.
        //SingletonClass singleInstance = SingletonClass.getInstance();
        singleInstance.setId(id);
        singleInstance.setName(name);
        System.out.println(Thread.currentThread().getName() + "Retrieve details: " + singleInstance.toString());
    }

}

