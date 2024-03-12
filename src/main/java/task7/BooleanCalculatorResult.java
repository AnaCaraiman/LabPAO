package task7;

public class BooleanCalculatorResult extends CalculatorResult{

    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Boolean computeresult() {
        Boolean leftoperand = (Boolean) getrequest().getleftoperand();
        Boolean rightoperand = (Boolean) getrequest().getrightoperand();
        switch (getrequest().getoperation()) {
            case "AND":
                return leftoperand && rightoperand;
            case "OR":
                return leftoperand || rightoperand;
            default:
                return null;
        }
    }
}
