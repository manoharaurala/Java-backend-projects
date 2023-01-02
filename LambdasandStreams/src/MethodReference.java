import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //paramter as an argument
        //directly pass

        numbers.forEach(e->System.out.println(e));


        //paarmter as an static method

        numbers.stream()
                        .map(e->String.valueOf(e))
                                .forEach(System.out::println);

        numbers.stream()
                        .map(String::valueOf)
                                .forEach(System.out::println);

        //parameter as argument

        numbers.stream()
                        .map(e->e.toString())
                                .forEach(System.out::println);

        numbers.stream()
                        .map(e->String.valueOf(e))
                                .map(String::toString)
                                        .forEach(System.out::println);






    }
}
