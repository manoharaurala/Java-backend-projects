public class ThrowExcep {
    static void fun() throws IllegalAccessException{
        throw  new IllegalAccessException("Test");
    }

    public static void main(String[] args) {
        try {
           fun();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();

        }
    }
}
