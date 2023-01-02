import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Person, Boolean> hm=new HashMap<>();
        Person person1 = new Person(1, 10, "ABC");
        Person person2 = new Person(1, 10, "ABC");
        hm.put(person1,true);
        hm.put(person2,true);
        System.out.println("Size of hash map: "+hm.size());
        Person person3 = new Person(2, 15, "ABC");
        hm.put(person3, true );
        hm.put(person2, true);
        hm.put(person1, false);
        boolean ans = hm.get(person3);
        System.out.println(ans);
        System.out.println("Size of hash map: "+hm.size());
    }
}
