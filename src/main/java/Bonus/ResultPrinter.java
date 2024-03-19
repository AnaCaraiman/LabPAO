package Bonus;

import java.util.List;

public class ResultPrinter {
    public void printResults(List<CalculationResult> results) {
        for (CalculationResult result : results) {
            CalculationRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}
