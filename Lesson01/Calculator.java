import java.util.Scanner;

public class Calculator
{
    public static void main(String args[])
    {
        Scanner userInput = new Scanner(System.in);
        String calcInput;

        System.out.println("Calculadora");
        System.out.print(" -> ");
        calcInput = userInput.nextLine();

        int a = Integer.parseInt(calcInput.split(" ")[0]);
        int b = Integer.parseInt(calcInput.split(" ")[2]);
        String operator = calcInput.split(" ")[1];

        if(!operator.equals("/") && !operator.equals("*") && !operator.equals("+") && !operator.equals("-"))
        {
            System.err.println("Operador inválido");
        }
        else
        {
            switch(operator)
            {
                case "/":
                    System.out.println(a + " " + operator + " " + b + " = " + division(a,b));
                    break;

                case "*":
                    System.out.println(a + " " + operator + " " + b + " = " + multiplication(a,b));
                    break;
                
                case "+":
                    System.out.println(a + " " + operator + " " + b + " = " + sum(a,b));
                    break;

                case "-":
                    System.out.println(a + " " + operator + " " + b + " = " + subtract(a,b));
                    break;
            }
        }
    }

    static double multiplication(double a, double b)
    {
        return a*b;
    }

    static double division(double a, double b)
    {
        return a/b;
    }

    static double sum(double a, double b)
    {
        return a+b;
    }

    static double subtract(double a, double b)
    {
        return a-b;
    }
}