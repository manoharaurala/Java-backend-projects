abstract class Shape {
    String color;
    abstract  double area();
    public abstract  String toString();
    public Shape(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
}
