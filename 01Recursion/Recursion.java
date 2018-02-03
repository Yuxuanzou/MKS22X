public class Recursion {
    public int fact(int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        if (n == 1){
            return 1;
        }
        else if (n == 0){
            return 1;
        }
        return fact(n - 1) + n;
    }
    
    public static void main(String[] args){
        Recursion r = new Recursion();
        System.out.println(r.fact(4));
        System.out.println(r.fact(0));
        System.out.println(r.fact(1));
        System.out.println(r.fact(20));
        System.out.println(r.fact(-2));
    }
}