import java.util.Arrays;
import java.util.List;

public class TestParallelStream {
    public static void main(String[] args) {
        //stream as abstraction
        List<Integer> l1= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Timet.code(()->
        System.out.println(
                l1.parallelStream()
                        .filter(e->e%2==0)
                        .mapToInt(TestParallelStream::compute)
                        .sum()));



    }

    private static int compute(Integer integer) {
        try {
            Thread.sleep(1000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  integer*2;
    }
}
