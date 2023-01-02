import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GFC {
    public static void main(String[] args) {

        PriorityQueue q=new PriorityQueue();
        q.add(6);
        q.add(5);
        q.add(3);
        q.add(4);

        System.out.println(q.peek());
        System.out.println(q.size());

    }
}
