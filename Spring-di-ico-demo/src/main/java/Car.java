public class Car {
    private String name;
    private Engine engine;


    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public Car() {
        System.out.println("creating empty car");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        System.out.println(name+" car is running with engine "+engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
