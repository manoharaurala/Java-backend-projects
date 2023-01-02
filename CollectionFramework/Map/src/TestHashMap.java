import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,String> m1=new HashMap<>();
        m1.put(1,"Laxmi");
        m1.put(2,"Aanemari");
        m1.put(3,"piidi");
        System.out.println(m1.get(4));
        for(Map.Entry m:m1.entrySet()){
            System.out.println("key is: "+m.getKey()+"value is: "+m.getValue());
        }
    }

}
