class Sum {
    public int addition(int a, int b) {
        return a+b;
    }

    public int addition(int a, int b, int c) {
        return a+b+c;
    }
}

public class Main {
    public static void main (String args[]) {
        Sum sum = new Sum();
        //same methods name with different argument sets
        System.out.println(sum.addition(14, 25));
        System.out.println(sum.addition(10, 15, 20));
    }
}