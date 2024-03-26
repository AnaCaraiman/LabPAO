package task1;

public class Test {
    public static void main(String[] args) {
        try {
            throw new JustMyFirstException();
        } catch (JustMyFirstException e) {
            System.out.println("JustMyFirstException: " + e.getMessage());
        }
    }
}
