import p2utils.Queue;
import p2utils.Stack;


public class Palindrome
{
    public static void main(String args[])
    {
        if(args.length < 1 )
        {
            System.out.println("java Palindrome <frase ou palavra>");
        }

        String sentence = "";
        for(String s : args)
        {
            sentence += " " + s;
        }


        if(isPalindrome(sentence))
        {
            System.out.println("A palavra " + sentence + " é um palíndromo");
        }
        else
        {
            System.out.println("A palavra '" + sentence + "' não é um palíndromo");
        }
    }

    public static boolean isPalindrome(String sentence)
    {
        Queue<String> q = new Queue<String>();
        Stack<String> s = new Stack<String>();

        for(char c : sentence.toCharArray())
        {
            if(Character.isLetterOrDigit(c)) 
            {
                q.in(String.valueOf(Character.toLowerCase(c)));
                s.push(String.valueOf(Character.toLowerCase(c)));
            }
        }

        do
        {
			if(s.top().compareTo(q.peek()) != 0) return false;
			s.pop();
			q.out();
        }
        while(!s.isEmpty());
         
        return true;
    }
}