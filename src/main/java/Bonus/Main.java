package Bonus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        SmarterCalculator calculator = new SmarterCalculator();
        ResultPrinter printer = new ResultPrinter();

        calculator.calculateAndPrintResults(args, printer);
    }
}
