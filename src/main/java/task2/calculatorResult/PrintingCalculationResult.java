package task2.calculatorResult;

import task2.CalculationRequest;
import task2.Exceptions.InvalidOperationException;

public class PrintingCalculationResult implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        try {
            Object result = calculationResult.computeResult();
            CalculationRequest request = calculationResult.getRequest();
            System.out.println("Operation " + request + " has result " + result);
            return result;
        } catch (Exception e) {

            throw new InvalidOperationException("Error result: " + e.getMessage());
        }
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}

