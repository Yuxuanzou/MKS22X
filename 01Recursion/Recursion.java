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
    
    public int fib(int n){
        if (n < 0){
            throw new IllegalArgumentException();
        }
        return helper(0,n,0,1);
    }
    
    public int helper(int sum, int n, int small, int large){
        int temp = small;
        if (n == 0){
            return sum;
        }
        else if (n == 1){
            return large;
        }
        return helper(sum = small + large,n - 1, small = large, large + temp);
    }
    
    public double sqrt(double n){
        
    }
    
    public static void main(String[] args){
        Recursion r = new Recursion();
        System.out.println(r.fact(4));
        System.out.println(r.fact(0));
        System.out.println(r.fact(1));
        System.out.println(r.fib(35));
        System.out.println(r.fib(-1));
    }
}