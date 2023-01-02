import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1=new LinkedList<Integer>();
        l1.add(5);
        l1.add(10);
        l1.add(17);
        Iterator<Integer> itr=l1.iterator();
        while(itr.hasNext()){
            System.out.println("Integer stord in Linkedin: "+itr.next());
        }
    }
}
