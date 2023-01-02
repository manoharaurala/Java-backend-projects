import java.util.Arrays;

public class TwoCandidates {
    static Boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
    int first=0;
    int last=n-1;
    arr= Arrays.stream(arr).sorted().toArray();

    while(first<last){
        if (arr[first]+arr[last]==x)
        {
            return true;
        } else if (arr[first]+arr[last]<x) {
            first++;

        }
        else{
            last--;
        }
    }
    return false;



    }

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
}
