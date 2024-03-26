package task2.Exceptions;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException {
    public InvalidArgumentsLengthException(String message) {
        super(message);
    }
}