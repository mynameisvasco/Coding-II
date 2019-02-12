import java.util.Scanner;

public class IsPrime
{
    public static void main(String[] args)
    {
        int n = 0;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Verificar se um número é primo");
        System.out.print("-> ");

        n = userInput.nextInt();

        if(isPrime(n))
        {
            System.out.println(n + " é primo");
        }
        else
        {
            System.out.println(n + " não é primo");
        }

    }

    public static boolean isEaven(int n)
    {
        if(n % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isPrime(int n)
    {
        if(isEaven(n))
        {
            return false;
        }
        else
        {
            for(int i = 2; i < n; i++)
            {
                if(n % i == 0)
                {
                    return false;
                }
            }

            return true;
        }
    }
}