package task7;

public class CalculatorRequest {
    private Object leftoperand;
    private Object rightoperand;
    private String operation;

    public CalculatorRequest(Object leftoperand, Object rightoperand, String operation) {
        this.leftoperand = leftoperand;
        this.rightoperand = rightoperand;
        this.operation = operation;
    }






    public Object getleftoperand() {
        return leftoperand;
    }
    public String getoperation() {
        return operation;
    }

    public Object getrightoperand() {
        return rightoperand;
    }
    public String Getrequesttype() {
        if (leftoperand instanceof Integer && rightoperand instanceof Integer) {
            return "integer";
        } else if (leftoperand instanceof Double || rightoperand instanceof Double) {
            return "double";
        } else if (leftoperand instanceof Boolean && rightoperand instanceof
                Boolean) {
            return "boolean";
        }
        return "unknown";
    }

    @Override
    public String toString() {
        return leftoperand + " " + operation + " " + rightoperand;
    }
}
