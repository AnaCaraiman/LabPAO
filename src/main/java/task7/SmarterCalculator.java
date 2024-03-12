package task7;

import java.util.List;
import java.util.ArrayList;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> requests = InputConverter.maprequests(args);
        List<CalculatorResult> results = new ArrayList<>();
        for (CalculatorRequest request : requests) {
            switch (request.getleftoperand().getClass().getSimpleName()) {
                case "Integer":
                    results.add(new IntegerCalculatorResult(request));
                    break;
                case "Double":
                    results.add(new DoubleCalculatorResult(request));
                    break;
                case "Boolean":
                    results.add(new BooleanCalculatorResult(request));
                    break;
                default:
                    System.out.println("Invalid request: " + request);
                    break;
            }
        }
        return results;
    }
}


