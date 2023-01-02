public class MultiThreadDemo {
    public static void main(String[] args) {
        int n=8;
        for(int i=0;i<n;i++){
            CreateNewThread thread=new CreateNewThread();
            thread.start();
        }
    }
}
