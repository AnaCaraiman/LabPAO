package task7;

public class DummyCalculator {
    public void calculate(String[] args) {
        if (args.length != 3) {
            System.out.println("Input invalid.Doar 2 termeni.");
            return;
        }

        try {
            String operator = args[1];
            double operand1 = Double.parseDouble(args[0]);
            double operand2 = Double.parseDouble(args[2]);

            double result;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        System.out.println("Nu se poate imparti la zero.");
                        return;
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Operator invalid.");
                    return;
            }

            if (isInteger(operand1) && isInteger(operand2)) {
                System.out.println("Output: " + (int) result);
            } else {
                System.out.println("Output: " + result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input invalid. Numere invalide.");
        }
    }

    private boolean isInteger(double num) {
        return num == (int) num;
    }
}

