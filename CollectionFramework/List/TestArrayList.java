import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> a=new ArrayList<String>();
        a.add("Ruby");
        a.add("Kariya");
        a.add("Aanemari");
        a.add("Piddi");
        a.add("Annaya");
        Iterator i=a.iterator();
        while(i.hasNext()){
            System.out.println("Elelement in ArrayList: "+i.next());
        }
    }
}
