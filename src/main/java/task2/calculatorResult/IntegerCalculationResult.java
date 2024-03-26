package task2.calculatorResult;

import task2.CalculationRequest;
import task2.Exceptions.InvalidOperationException;

public class IntegerCalculationResult extends AbstractCalculationResult {
    public IntegerCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Integer leftOperand = (Integer) request.getLeftOperand();
        Integer rightOperand = (Integer) request.getRightOperand();

        return switch (request.getOperation()) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            default -> throw new InvalidOperationException( "Invalid operation");
        };
    }
}
