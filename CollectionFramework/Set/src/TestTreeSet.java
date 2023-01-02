import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        SortedSet<String> s1=new TreeSet<>();
        s1.add("Pakka");
        s1.add("bala");
        s1.add("kitta");
        s1.add("manohara");
        Iterator i1=s1.iterator();
        while(i1.hasNext()){
            System.out.println(i1.next());
        }
    }
}
