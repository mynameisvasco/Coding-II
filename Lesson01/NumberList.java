import java.util.Scanner;

public class NumberList
{
    public static double sum = 0;
    public static int n = 0;
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        double d;

        do
        {
            System.out.print("Insira um número -> ");

            d = userInput.nextInt();
            
            if(d != 0)
            {
                sum += d;
                n += 1;
            }

        }
        while(d != 0);

        if(sum > 0)
        {
            System.out.println("Soma -> " + sum);
            System.out.println("Média -> " + (double) sum/n);
        }
        else
        {
            System.out.println("Soma -> " + sum);
            System.out.println("Média -> Inexistente");
        }
    }
}