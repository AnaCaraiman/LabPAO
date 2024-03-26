package task2;

import task2.calculatorResult.PrintingCalculationResult;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "nu", "+", "2",
                "2", "*", "re3",
                "1", "+", "5.0",
                "1.0", "+", "2",
                "10.0", "/", "1",
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .forEach(result -> {
                    try {
                        result.computeResult();
                    } catch (Exception e) {
                        System.err.println("Error result: " + e.getMessage());
                    }
                });
    }
}
