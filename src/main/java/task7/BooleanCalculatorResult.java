package task7;

public class BooleanCalculatorResult extends CalculatorResult{

    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Boolean computeResult() {
        Boolean leftoperand = (Boolean) getRequest().leftOperand();
        Boolean rightoperand = (Boolean) getRequest().rightOperand();
        switch (getRequest().operation()) {
            case "AND":
                return leftoperand && rightoperand;
            case "OR":
                return leftoperand || rightoperand;
            default:
                return null;
        }
    }
}
