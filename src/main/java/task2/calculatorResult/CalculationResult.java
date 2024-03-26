package task2.calculatorResult;

import task2.CalculationRequest;

public interface CalculationResult {
    Object computeResult() throws Exception;
    CalculationRequest getRequest();
}