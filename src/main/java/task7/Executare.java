package task7;

import java.util.List;
import task7.CalculatorResult;
import task7.CalculatorRequest;
import task7.SmarterCalculator;


public class Executare {
    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }

    public static void executare(String[] args) {
        String[] input = {
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1"
        };

        foo(input);
    }

    public static void main(String[] args) {
        executare(args);
    }
}