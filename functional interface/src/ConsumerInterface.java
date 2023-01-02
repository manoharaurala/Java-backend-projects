import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

interface Consumer<T>{
    public void test(Integer i);
}


public class ConsumerInterface {

    public static void main(String[] args) {
        Consumer<Integer> consumer=(value)->System.out.println(value);
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
      for(Integer i:numbers){
          consumer.test(i);
      }
    }
}
