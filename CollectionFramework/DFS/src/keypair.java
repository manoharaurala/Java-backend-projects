import java.util.ArrayList;
import java.util.Iterator;

public class keypair {
    public static void main(String[] args) {
        int n=6;
        int x=16;
        int arr[]={1,4,45,6,10,8};
        Boolean ans=hasArrayTwoCandidates(arr,n,x);
        n=5;
        x=10;
        int arr2[]={1,2,4,3,6};
        Boolean an2=hasArrayTwoCandidates(arr2,n,x);
        System.out.println("1s set: "+ans);
        System.out.println("2nd set: "+an2);
    }

    private static Boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
    Boolean flag=false;
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> temp;
        int sum=0;
        for(int i:arr){
            al1.add(i);
        }
        for(int i=0;i<n;i++){

            int n1=arr[i];
            temp= (ArrayList<Integer>) al1.clone();

            temp.remove(
                    Integer.valueOf(n1)
            );
            Iterator i1=temp.iterator();
            while(i1.hasNext()){
                int n2=(int) i1.next();
                sum=n1+n2;
                if(sum==x){
                    return true;
                }
                sum=0;
            }

        }







    return flag;
    }

}
