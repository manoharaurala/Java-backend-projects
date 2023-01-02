public class Rectangle extends Shape {
 double width,length;
    public Rectangle(String color,double width,double length) {
        super(color);
        this.width=width;
        this.length=length;
    }

    @Override
    double area() {
       return length*width;
    }

    @Override
    public String toString() {
        return "Color is : "+super.getColor()+"And area is : "+this.area();
    }
}
