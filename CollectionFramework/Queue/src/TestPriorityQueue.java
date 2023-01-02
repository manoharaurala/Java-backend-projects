import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        Queue<String> q1=new PriorityQueue<String>();
        q1.add("Laxmi");
        q1.add("Aanemari");
        q1.add("Piddi");
        q1.add("Ruby");

        System.out.println("Peek: "+q1.peek());
        System.out.println("Head: "+q1.element());
        Iterator i1=q1.iterator();
        while(i1.hasNext()){
            System.out.println("Elements in queue: "+i1.next());
        }
        q1.remove("Ruby");
        q1.poll();
        System.out.println("after removing two elemnts in queue");
        Iterator i2=q1.iterator();
        while(i2.hasNext()){
            System.out.println("Elements in queue: "+i2.next());
        }
        System.out.println("Peek: "+q1.peek());
        System.out.println("Head: "+q1.element());

    }
}
