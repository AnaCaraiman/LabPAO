package task7;
public record CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
    public String Getrequesttype() {
        if (leftOperand instanceof Integer && rightOperand instanceof Integer) {
            return "integer";
        } else if (leftOperand instanceof Double || rightOperand instanceof Double) {
            return "double";
        } else if (leftOperand instanceof Boolean && rightOperand instanceof Boolean) {
            return "boolean";
        }
        return "unknown";
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }
}




