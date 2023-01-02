public class TestAnonymousFunction {
    public static void main(String[] args) {

        //1.Name
            //2.param
  //Lambda  //3.body
        //4.return type
        Thread t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));
        t=new Thread(()-> System.out.println("In another thread"));

        t.start();

        System.out.println("from main thread");
    }
}
