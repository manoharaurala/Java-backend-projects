public class UsingLambda {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("New Thread started");
        }

        ).start();
    }
}
