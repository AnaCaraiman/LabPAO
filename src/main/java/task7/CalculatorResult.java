package task7;

public abstract class CalculatorResult {
    private final CalculatorRequest request;


    protected CalculatorResult(CalculatorRequest calculatorrequest) {
        this.request = calculatorrequest;
    }

    public CalculatorRequest getrequest() {
        return request;
    }

    public Object computeresult() {
        return null;
    }

}

