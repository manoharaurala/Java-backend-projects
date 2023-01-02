import java.util.*;
import java.util.function.Consumer;

public class Imperative {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //external interator
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //external iterator
        for (int i : numbers) {
            System.out.println(i);
        }

        //internal iterator
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
        numbers.forEach((Integer value) -> System.out.println(value));

        // numbers.forEach( value->System.out.println(value));
        //java 8 has type inference but only for lambda expression
        //parenthesis is optional but only one paramter lambda

        numbers.forEach(System.out::println);

        //while lambda are really cute keep them that way

        //not good
        //number.forEach(e ->{
       // ..;
      //  ..;
       // return
   // }0;


    }
}
