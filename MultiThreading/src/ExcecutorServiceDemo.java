import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService fixexecutorservice= Executors.newFixedThreadPool(10);
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println("Thread "+Thread.currentThread().getName());

                }


        );
        executorService.shutdown();
    }
}
