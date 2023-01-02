import java.util.concurrent.*;

public class ThreadPoolExecutorDemp {
    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;
        ExecutorService threadpoolexcecutor=
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(4)
                );
        CountDownLatch countDownLatch = new CountDownLatch(9);
       // Runnable runnable = new Runnable() {
        //    @Override
        //    public void run() {
          //      System.out.println("Executed in thread: "+Thread.currentThread().getName());
          //      countDownLatch.countDown();
          //  }
       // };


        Runnable runnable=()->{
            System.out.println("Executed in thread: "+Thread.currentThread().getName());
            countDownLatch.countDown();
        };
        for(int i=0;i<10;i++){
            threadpoolexcecutor.submit(runnable);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done "+Thread.currentThread().getName());



    }
}
