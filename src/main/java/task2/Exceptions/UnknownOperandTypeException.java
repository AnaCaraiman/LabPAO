package task2.Exceptions;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String message) {
        super(message);
    }
}