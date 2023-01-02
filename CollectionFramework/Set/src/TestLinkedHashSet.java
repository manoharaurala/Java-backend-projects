import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<String> s1=new LinkedHashSet<>();
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
