import java.util.ArrayList;
import java.util.Stack;

public class ValidExpression {
    public static boolean valid(String s){
        boolean flag=false;
        Stack<Character> stk=new Stack<>();
        ArrayList<Character> alist=new ArrayList<>();
        alist.add('(');
        alist.add('{');
        alist.add('[');


        for(int i=0;i<s.length();i++) {
            char str = s.charAt(i);
            if (alist.contains(str)) {
                stk.push(str);
            }
            else {
                char ele;
                if(!(stk.isEmpty())) {
                     ele = stk.pop();
                }
                else {
                    flag = false;
                    break;

                }
                if ((ele == '(' && str == ')') || (ele == '[' && str == ']') || (ele == '{' && str == '}')) {
                    flag=true;
                } else {
                    flag = false;
                    break;
                }
            }
        }


        if(flag&& stk.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s1="()[]{}";
        String s2="())({}";
        String s3="([)}";
        System.out.println("String is in correct oder: "+valid(s1));
        System.out.println("String is in correct oder: "+valid(s2));
        System.out.println("String is in correct oder: "+valid(s3));

    }
}
