import java.util.Scanner;

public class calculator {

    //ADD 34 3
    //SUB 31 2
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String raw_expr = scanner.nextLine();
                if (raw_expr.equals("exit")) break;
                String[] expr = raw_expr.split(" ");
                if (expr.length != 3){
                    throw new IllegalArgumentException("Invalid expression");
                }
                try{
                    String operator = expr[0];
                    int operand1 = Integer.parseInt(expr[1]);
                    int operand2 = Integer.parseInt(expr[2]);
                    int result = evaluate(operator,operand1, operand2);
                    System.out.println(result);
                } catch (Exception e){
                    throw new IllegalArgumentException("We couldn't parse your input", e);
                }
            }

            scanner.close();
        }
    }

    private static int evaluate(String operator, int operand1, int operand2) {
        switch (operator) {
            case "ADD":
                return operand1 + operand2;
            case "SUB":
                return operand1 - operand2;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
}