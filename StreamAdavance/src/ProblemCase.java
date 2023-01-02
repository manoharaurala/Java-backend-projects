import java.util.stream.Stream;

public class ProblemCase {
    public static void main(String[] args) {
        //Given a number k and count n find total double of n
        //Given number starting with k, where sqrt of each number is >20
        int k=121;
        int n=51;
        System.out.println(compute(k,n));








    }

    private static int compute(int k, int n) {

        int result;


        return Stream.iterate(k,e->e+1)  //unbounded lazy
                .filter(e->e%2==0)//unbounded lazy
                .filter(e->Math.sqrt(e)>20)//unbounded lazy
                .mapToInt(e->e*2)   //unmbounded lazy
                .limit(n)    //sized lazy
                .sum();


        //any function return stream lazy
        //filter map limit



    }
}
