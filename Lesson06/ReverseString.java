public class ReverseString
{
    public static void main(String[] args)
    {
        System.out.println(reverseString(args[0]));
    }

    public static String reverseString(String s)
    {
        if(s.isEmpty())
        {
            return s;
        }

        return reverseString(s.substring(1))+s.charAt(0);
    }
}