import java.util.Iterator;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> s1=new Stack<Integer>();
        s1.push(5);
        s1.push(3);
        s1.push(7);
        s1.push(9);
        s1.push(4);
        System.out.println("Peek: "+s1.peek());
        s1.pop();
        Iterator i1=s1.iterator();
        while(i1.hasNext()){
            System.out.println("elements in stack: "+i1.next());
        }

    }
}
