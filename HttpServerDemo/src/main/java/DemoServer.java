import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        System.out.println("testing the server");
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Enter request data:");
            String data= sc.nextLine();
            if(data=="exit") {
                executorService.shutdown();

                System.exit(0);
            }


                executorService.submit(() ->
                        {
                            System.out.println("Worker Thread:" + Thread.currentThread().getName() + "processing data: " + data);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                );

        }
    }
}
