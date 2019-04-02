public class Mdc
{
    public static void main(String[] args)
    {
        assert args.length == 2 : "Argumentos em falta: java Mdc a b";
        int a = 0;
        int b = 0;
        try 
        {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        } 
        catch (NumberFormatException e) 
        {
            System.out.println(e);
        }

        assert a > 0 && b > 0 : "a e b tem de ser números positivos";

        System.out.println("MDC(" + a + "," + b + ") = " + calcMdc(a,b));
    }

    static int calcMdc(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return calcMdc(b, a % b);
    }
}