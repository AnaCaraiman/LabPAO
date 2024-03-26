package task2;
import task2.calculatorResult.BooleanCalculationResult;
import task2.calculatorResult.CalculationResult;
import task2.calculatorResult.DoubleCalculationResult;
import task2.calculatorResult.IntegerCalculationResult;

import java.util.List;
import java.util.stream.Collectors;


public class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) {
        return InputConverter.mapRequests(args)
                .stream()
                .map(SmarterCalculator::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}
