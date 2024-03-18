package task7;

public abstract class CalculatorResult {
    private final CalculatorRequest request;

    protected CalculatorResult(CalculatorRequest request) {
        this.request = request;
    }

    public CalculatorRequest getRequest() {
        return request;
    }


    public abstract Object computeResult();
}


