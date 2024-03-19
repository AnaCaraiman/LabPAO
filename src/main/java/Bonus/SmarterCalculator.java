package Bonus;
import Bonus.InputConvertor;
import Bonus.ResultPrinter;
import java.util.List;
import java.util.stream.Collectors;


public class SmarterCalculator {

    public List<CalculationResult> calculate(String[] args) {
        return InputConvertor.mapRequests(args)
                .stream()
                .map(this::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    public void calculateAndPrintResults(String[] args, ResultPrinter printer) {
        List<CalculationResult> results = calculate(args);
        printer.printResults(results);
    }

    private CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}