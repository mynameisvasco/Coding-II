import p2utils.*;

public class Rodrigo
{
    public static void main(String args[])
    {
        Stack<String> pilha = new Stack<String>();
        pilha.push("Rodrigo");
        pilha.push("Couto");
        pilha.push("Vasco");

        pilha.pop();
        System.out.println(pilha.top());

    }
}