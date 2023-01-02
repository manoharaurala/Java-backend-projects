import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        String data = "name:"+this.name+", price:"+this.price;
        out.write(data.getBytes());

    }
}
