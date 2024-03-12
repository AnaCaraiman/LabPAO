package task7;

public class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Object computeresult() {
        Object leftOperand = getrequest().getleftoperand();
        Object rightOperand = getrequest().getrightoperand();
        String operation = getrequest().getoperation();

        switch (operation) {
            case "+":
                return convertToDouble(leftOperand) + convertToDouble(rightOperand);
            case "-":
                return convertToDouble(leftOperand) - convertToDouble(rightOperand);
            case "*":
                return convertToDouble(leftOperand) * convertToDouble(rightOperand);
            case "/":
                return convertToDouble(leftOperand) / convertToDouble(rightOperand);
            default:
                return null;
        }
    }

    private double convertToDouble(Object operand) {
        if (operand instanceof Double) {
            return (double) operand;
        } else if (operand instanceof Integer) {
            return ((Integer) operand).doubleValue();
        } else {
            throw new IllegalArgumentException("Eroare");
        }
    }
}

