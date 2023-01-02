import javafx.print.Collation;

import java.util.*;

public class KLargestElement {
    public static int[] kLargest(int[]arr,int n, int k){
        ArrayList<Integer> ss1=new ArrayList<>();
        for(int i:arr){
            ss1.add(i);
        }
        Collections.sort(ss1);



        int temp[]=new int[n];
        int ret[]=new int[k];
        int count=0;
        Iterator<Integer> i1=ss1.iterator();
        while(i1.hasNext()){
            temp[count]=(int)i1.next();
            count++;

        }
        count=n-1;
        for(int i=0;i<k;i++){
            ret[i]=temp[count];
            count--;
        }



        return ret;

    }
    public static void main(String[] args) {
        int n=5;
        int k=2;
        int arr1[]={12,5,787,1,23};
        System.out.println("2 large no.s are: ");
        arr1=kLargest(arr1,n,k);
        for(int i : arr1){
            System.out.print(i+" ");
        }

        n=7;
        k=3;
        int arr2[]={1,23,12,9,30,2,50};
        System.out.println("\n");
        System.out.println("3 large no.s are: ");
        arr2=kLargest(arr2,n,k);
        for(int i : arr2){
            System.out.print(i+" ");
        }

    }
}
