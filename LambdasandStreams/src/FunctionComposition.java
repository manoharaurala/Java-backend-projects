import java.util.Arrays;
import java.util.List;

public class FunctionComposition {
    public static void main(String[] args) {
        List<Integer> l1= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //given the values double thje even no and total

        //imperative style
        int result=0;
        for(int e:l1){
            if(e%2==0){
                e=e*2;
                result+=e;
            }

        }





        System.out.println(result);

        //function composition pipeline

        //stream of data

        System.out.println(l1.stream()
                .filter(e->e%2==0)
                .mapToInt(e->e*2)
                .sum());


    }
}
