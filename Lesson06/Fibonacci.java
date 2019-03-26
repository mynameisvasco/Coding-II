public class Fibonacci
{
    public static int currentTerm = 1;
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("Utilize o comando da seguinte forma -> java Fibonacci nº de elementos desejados (Por ex. 50)");
        }
        else
        {
            int n = 0;

            try
            {
                n = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Introduza um n válido");
                System.exit(0);
            }

            /*
            int k = 0;
            int j = 1;

            if(n == 0)
            {
                System.out.println("");
                System.exit(0);
            }
            else if(n == 1)
            {
                System.out.println(k);
                System.exit(0);
            }
            else if(n == 2)
            {
                System.out.println(k);
                System.out.println(j);
                System.exit(0);
            }
            else
            {
                double time = (double) (System.nanoTime() * (0.000001));
                System.out.println(k);
                System.out.println(j);
                sequenceGenerator(k, j, n);
                time = (double) ((System.nanoTime() * (0.000001)) - time);
                System.out.println("Run in : " + time + " ms");
            }*/

            
            double time = (double) (System.nanoTime() * (0.000001));
            sequenceGeneratorMem(n);
            time = (double) ((System.nanoTime() * (0.000001)) - time);
            System.out.println("Run in : " + time + " ms");
        }
    }


    //Modo recursivo
    public static void sequenceGenerator(int k, int j, int n)
    {
        if(currentTerm == n - 2)
        {
            System.out.println(k+j);
        }
        else
        {
            currentTerm++;
            System.out.println(k+j);
            sequenceGenerator(j, k+j, n);
        }
    }
    
    //Modo memoria
    public static void sequenceGeneratorMem(int n)
    {
        int[] storedValues = new int[n];
        storedValues[0] = 0;
        storedValues[1] = 1;

        for(int i = 2; i < n; i++)
        {
            storedValues[i] = storedValues[i - 2] + storedValues[i - 1];
        }

        for(int i = 0; i < storedValues.length; i++)
        {
            System.out.println(storedValues[i]);
        }
    }
}