import java.util.Stack;
import java.util.Scanner;

public class CalculadoraPila {
    public static void main(String[] args) {
        Stack<Double> pila = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Ingresa una operación (+, -) o 'exit' para salir:");
            String input = scanner.next();

            if (input.equals("exit")) {
                break;
            }

            switch (input) {
                case "+":
                    // Realizar operación de suma
                    if (pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a + b);
                        System.out.println("Resultado: " + pila.peek());
                    } else {
                        System.out.println("No hay suficientes operandos en la pila.");
                    }
                    break;
                case "-":
                    // Realizar operación de resta
                    if (pila.size() >= 2) {
                        double b = pila.pop();
                        double a = pila.pop();
                        pila.push(a - b);
                        System.out.println("Resultado: " + pila.peek());
                    } else {
                        System.out.println("No hay suficientes operandos en la pila.");
                    }
                    break;
                default:
                    try {
                        // Intentar convertir la entrada en un número y agregarlo a la pila
                        double num = Double.parseDouble(input);
                        pila.push(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor ingresa un número o una operación válida.");
                    }
                    break;
            }
        }

        scanner.close();
    }
}
