import java.util.Iterator;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args) {
        Vector<Double> v1=new Vector<Double>();
        v1.add(3.2);
        v1.add(5.2);
        v1.add(9.0);
        v1.remove(1);
        Iterator i1=v1.iterator();
        while(i1.hasNext()){
            System.out.println("elements in Vector: "+i1.next());
        }
    }
}
