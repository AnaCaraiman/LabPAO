package task5;

public class main {
    public static void main(String[] args) {
     bar();
}
    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
        } catch (RuntimeException e) {
            System.out.println("fail");
        }
    }

}

