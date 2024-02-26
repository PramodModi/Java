package BasicDS;

public class SingletonThreadSafe {
    //The volatile keyword ensures that changes made to the instance variable are visible to all threads.
    private static volatile SingletonThreadSafe singletonThreadSafe;
    int id;
    String name;

    //The double-checked locking minimizes the cost of synchronization once the instance is created,
    // improving performance in scenarios where the instance already exists.
    public static SingletonThreadSafe getInstance(){
        if(singletonThreadSafe == null){
            synchronized(SingletonThreadSafe.class){
                if(singletonThreadSafe == null){
                    singletonThreadSafe = new SingletonThreadSafe();
                }
            }
        }
        return singletonThreadSafe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingletonThreadSafe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
