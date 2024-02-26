package BasicDS;

public class SingletonThreadSafeMainClass {
    public static void main(String[] args) {
        SingletonWorkerClass worker1 = new SingletonWorkerClass(1, "Pramod");
        SingletonWorkerClass worker2 = new SingletonWorkerClass(2, "Aarav");
        SingletonWorkerClass worker3 = new SingletonWorkerClass(3, "Akshita");
        SingletonWorkerClass worker4 = new SingletonWorkerClass(4, "Ritu");
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

    }
}
