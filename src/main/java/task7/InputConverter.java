package task7;

import java.util.List;
import java.util.ArrayList;

public class InputConverter {
    public static List<CalculatorRequest> maprequests(String[] args) {
    List<CalculatorRequest> requests = new ArrayList<>();
    for (int i = 0; i < args.length; i += 3) {
        if (i + 2 < args.length) {
            Object leftoperand = parseoperand(args[i]);
            Object rightoperand = parseoperand(args[i + 2]);
            String operation = args[i + 1];
            CalculatorRequest request = new CalculatorRequest(leftoperand, rightoperand, operation);
            requests.add(request);
        }
    }
    return requests;
}


    private static Object parseoperand(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e1) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e2) {
                if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(str);
                }
            }
        }
        return null;
    }
}

