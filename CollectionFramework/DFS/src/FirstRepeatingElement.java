import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr,int n){
        Map<Integer,Integer> m1=new LinkedHashMap<Integer,Integer>();
        int count=1;
        ArrayList<Integer> alist=new ArrayList<Integer>();
        for(int i:arr) {
            if (m1.get(i) == null) {
                m1.put(i, count);
            } else {
                count = m1.get(i) + 1;
                m1.put(i, count);
            }
            count=1;
        }
            for (Map.Entry m : m1.entrySet()) {
                int val = (int) m.getValue();
                int key = (int) m.getKey();
                if (val > 1) {
                    alist.add(key);
                }

        }


        int ret=-1;
        for(int i=0;i<arr.length;i++){
            int ele=arr[i];
            if (alist.contains(ele)){
                ret=i+1;
                break;            }
        }
        return ret;

        }





    public static void main(String[] args) {
        int n=10;
        int []arr={1,2,3,4,5,6,7,8,3,4};
        int ret=firstRepeated(arr,n);
        System.out.println("Ret: "+ret);
    }
}
