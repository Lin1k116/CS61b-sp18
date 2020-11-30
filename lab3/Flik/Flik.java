/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    public static void main(String[] args) {
        boolean a = isSameNumber(129, 129);
        boolean b = isSameNumber(127, 127);
        System.out.println(a);
        System.out.println(b);
    }
}

