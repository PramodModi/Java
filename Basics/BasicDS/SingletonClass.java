package BasicDS;

public class SingletonClass {
    private static SingletonClass singleInstance;
    int id;
    String name;

    private SingletonClass(){

    }
    public static SingletonClass getInstance(){
        if(singleInstance == null){
            singleInstance =  new SingletonClass();
        }
        return singleInstance;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingletonClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


