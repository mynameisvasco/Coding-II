import java.util.Scanner;

public class AlbertoTranslator
{   
    public static void main(String args[])
    {
        Scanner userInput = new Scanner(System.in);
        String s;

        System.out.println("Tradutor da terra do Alberto");
        System.out.print("-> ");
        s = userInput.nextLine();

        System.out.println("Tradução -> " + translate(s));
    }

    public static String translate(String s)
    {
        String t;
        t = s.replaceAll("R" , "");
        t = s.replaceAll("L" , "U");        
        t = s.replaceAll("r" , "");
        t = s.replaceAll("l" , "u");

        return t;
    }
}