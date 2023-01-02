public class FunctionalInterface {
    public static void main(String[] args) {
        int a=5;
        Square s=(val)->val*val;
        int ans=s.calculate(a);
        System.out.println(ans);

    }
}
