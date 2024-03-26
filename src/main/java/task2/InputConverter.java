package task2;
import task2.Exceptions.InvalidArgumentsLengthException;
import task2.Exceptions.UnknownOperandTypeException;
import task2.requestMapper.CalculatorRequestMapper;
import task2.requestMapper.BooleanCalculatorRequestMapper;
import task2.requestMapper.DoubleCalculatorRequestMapper;
import task2.requestMapper.IntegerCalculatorRequestMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



public class InputConverter {

    private static final List<CalculatorRequestMapper> MAPPERS = Arrays.asList(new BooleanCalculatorRequestMapper(), new IntegerCalculatorRequestMapper(), new DoubleCalculatorRequestMapper());

    public static List<CalculationRequest> mapRequests(String[] args) throws InvalidArgumentsLengthException {
        if (args.length < 3 || args.length % 3 != 0) {
            throw new InvalidArgumentsLengthException("Invalid number of arguments provided.");
        }

        List<CalculationRequest> calculatorRequests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            try {
                calculatorRequests.add(mapRequest(args[i], args[i + 1], args [i + 2]));
            } catch (UnknownOperandTypeException e) {
                System.err.println("Unknown operand type: " + e.getMessage());
            }
        }


        return calculatorRequests;
    }

    private static CalculationRequest mapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString) throws UnknownOperandTypeException {
        for (CalculatorRequestMapper mapper : MAPPERS) {
            Optional<CalculationRequest> calculatorRequestOptional = mapper.tryMapRequest(leftOperandString, operatorString, rightOperandString);
            if (calculatorRequestOptional.isPresent()) {
                return calculatorRequestOptional.get();
            }
        }

        throw new UnknownOperandTypeException("Unknown operand type for operation: " + leftOperandString + " " + operatorString + " " + rightOperandString);
    }




}
