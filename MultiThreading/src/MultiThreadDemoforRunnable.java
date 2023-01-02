public class MultiThreadDemoforRunnable {
    public static void main(String[] args) {
        int n=10;
        for(int i=0;i<n;i++){
            Thread tr=new Thread(new CreateNewThreadByRunnable());
            tr.start();

        }
    }
}
