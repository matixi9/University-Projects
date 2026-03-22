class MathUtils {

    public static int silnia(int n) {
        if (n > 0) {
            return n * silnia(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Silnia z 5: " + silnia(5));
    }
}