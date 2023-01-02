import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,1,2,3,4,5);
        numbers.stream()
                .filter(e->e%2==0)
                //.sorted()
                //.distinct()
                .forEach(System.out::println);
        //sized ordered non distinct non sorted
    }
}
