import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class TestCollect {
    public static void main(String[] args) {
        List<Integer> l1= Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        //double the even value put to list

        //wrong way
        //mutability is ok sharing is nice shared mutability is devil work
        Set<Integer> doubleofEven2=
        l1.stream()
                .filter(e->e%2==0)
                .map(e->e*2)
                .collect(Collectors.toSet());

        System.out.println(doubleofEven2);


    }
}
