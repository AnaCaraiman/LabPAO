package task6;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeResult() {
        Object leftOperand = getRequest().leftOperand();
        Object rightOperand = getRequest().rightOperand();
        String operation = getRequest().operation();

        if (leftOperand instanceof Integer && rightOperand instanceof Double) {
            CalculatorRequest doubleRequest = new CalculatorRequest(((Integer) leftOperand).doubleValue(), (Double) rightOperand, operation);
            return new DoubleCalculatorResult(doubleRequest).computeResult();
        } else if (leftOperand instanceof Double && rightOperand instanceof Integer) {
            CalculatorRequest doubleRequest = new CalculatorRequest((Double) leftOperand, ((Integer) rightOperand).doubleValue(), operation);
            return new DoubleCalculatorResult(doubleRequest).computeResult();
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
        throw new IllegalArgumentException("Invalid request: " + getRequest());

    }
}


