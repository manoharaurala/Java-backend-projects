public class TestAnonymouseInnerclass {
    public static void main(String[] args) {

        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
           System.out.println("In another thread");
            }
        });
        t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });
        t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });
        t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });
                t.start();

        System.out.println("from main thread");
    }
}
