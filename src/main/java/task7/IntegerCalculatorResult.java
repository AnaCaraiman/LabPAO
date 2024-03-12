package task7;

import java.util.function.BinaryOperator;

public class IntegerCalculatorResult extends CalculatorResult{
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }
    @Override
    public Object computeresult() {
        Object leftOperand = getrequest().getleftoperand();
        Object rightOperand = getrequest().getrightoperand();
        String operation = getrequest().getoperation();
        if (leftOperand instanceof Integer && rightOperand instanceof Double) {
            CalculatorRequest doubleRequest = new CalculatorRequest(((Integer) leftOperand).doubleValue(), (Double) rightOperand, operation);
            return new DoubleCalculatorResult(doubleRequest).computeresult();
        } else if (leftOperand instanceof Double && rightOperand instanceof Integer) {
            CalculatorRequest doubleRequest = new CalculatorRequest((Double) leftOperand, ((Integer) rightOperand).doubleValue(), operation);
            return new DoubleCalculatorResult(doubleRequest).computeresult();
        } else if (leftOperand instanceof Integer && rightOperand instanceof Integer) {
            Integer result;
            switch (operation) {
                case "+":
                    result = (Integer) leftOperand + (Integer) rightOperand;
                    break;
                case "-":
                    result = (Integer) leftOperand - (Integer) rightOperand;
                    break;
                case "*":
                    result = (Integer) leftOperand * (Integer) rightOperand;
                    break;
                case "/":
                    result = (Integer) leftOperand / (Integer) rightOperand;
                    break;
                default:
                    throw new IllegalArgumentException("Operator necunoscut: " + operation);
            }
            return result;

        }
        throw new IllegalArgumentException("Invalid request: " + getrequest());

    }
}


