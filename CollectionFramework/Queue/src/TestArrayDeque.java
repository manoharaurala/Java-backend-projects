import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TestArrayDeque {
    public static void main(String[] args) {
        Queue<Integer> q1=new ArrayDeque<>();
        q1.add(1);
        Integer[] a1={2,3,4,5,6,7,8,910};
         q1.addAll(Arrays.asList(a1));
         for(int i:q1){
             System.out.println(i);
         }

    }
}
