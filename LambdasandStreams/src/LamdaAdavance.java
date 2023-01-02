import java.util.Arrays;
import java.util.List;

public class LamdaAdavance {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(
                numbers.stream()
                    .reduce(0,(total,e)->Integer.sum(total,e)));//order is important


        System.out.println(
                numbers.stream()
                        .reduce(0,Integer::sum)
        );

        numbers.stream()
                .map(String::valueOf)
                .reduce("",(carry,str)->carry.concat(str));

        numbers.stream()
                .map(String::valueOf)
                .reduce(String::concat);

        //cannot use when manupulatio of data
        //conflict beween static method and instance method






    }
}
