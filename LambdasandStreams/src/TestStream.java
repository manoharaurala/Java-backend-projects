import java.util.Arrays;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        List<Integer> l1= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Test filter
        System.out.println(
        l1.stream()
                .filter(e->e%2==0)
                .map(e->e*2.0)
                .reduce(0.0,(carry,e)->carry+e));

    //filter: 0<=no of elemts in output<=no of elements in the input
        //paramter:Stram<T> filter take Predicate<T>

        //Test map
        //map tranforms value
        //no of input==no of output
        //no gurantee of type of ouput wrt type of input
        //parameter:Stream<T> map takes Function<T,R> to return Stream<R>

        //both filter map stay with in their swimlane

        //reduce cuts acrorss swimlanes
        //takes intial value 0.0
        //carry=intial+e
        //carry=carry+e


        //reduce on Stram<T> takes two params
        //first param of type T
        //second param if type BiFunctional<R,t,R> to produce result R

        //specialized Reduce

        System.out.println(
                l1.stream()
                        .filter(e->e%2==0)
                        .mapToDouble(e->e*2.0)
                        .sum());

        //Reduce to value









    }
}
