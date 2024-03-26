package task2.calculatorResult;

import task2.CalculationRequest;
import task2.Exceptions.InvalidOperationException;

public class DoubleCalculationResult extends AbstractCalculationResult {
    public DoubleCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Double leftOperand = (Double) request.getLeftOperand();
        Double rightOperand = (Double) request.getRightOperand();

        return switch (request.getOperation()) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            default -> throw new InvalidOperationException( "Invalid operation");
        };
    }
}