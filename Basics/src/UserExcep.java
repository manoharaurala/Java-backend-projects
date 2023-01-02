public class UserExcep extends Exception {
    UserExcep(String s){
        super(s);
    }
}
class TestExcep{
    public static void main(String[] args) {
        try{
            throw new UserExcep("Testing from puttani");
        }
        catch (UserExcep e){
            System.out.println("msg passed is "+e.getMessage());
            e.printStackTrace();

        }
        finally {
            System.out.println("testing finaly block");
        }
    }
}
