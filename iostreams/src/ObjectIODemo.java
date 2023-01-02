import java.io.*;

public class ObjectIODemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObjectInFile();
        readObjectFromFile();
    }

    public static void writeObjectInFile() throws IOException {
        Product product = new Product("Laptop",40000.00);
     product.w
    }

    public static void readObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("G:\\JAVA Backend Course\\MyCode\\iostreams\\src\\tmp\\objectFile.txt"));
        Product product = (Product) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(product);
    }

}
