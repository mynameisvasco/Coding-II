import java.util.Scanner;
import java.io.*;

import p2utils.*;

public class CheckPassword 
{
    public static void main(String[] args) throws IOException
    {
        KeyValueList<String> kl = new KeyValueList<String>();
        Scanner sf = new Scanner(new File("senhas.txt"));
        while(sf.hasNextLine())
        {
            String line = sf.nextLine();
            String user = line.split(" ")[0];
            String password = line.split(" ")[1];
            kl.set(user, password);
        }
        sf.close();

        sf = new Scanner(System.in);
        System.out.print("Username: ");
        String usernameInput = sf.next();

        System.out.print("Password: "); 
        String passwordInput = sf.next();

        try
        {
            if(kl.get(usernameInput).equals(passwordInput))
            {
                System.out.println("Logado com sucesso!");
            }
            else
            {
                System.out.println("Autenticação falhada. (Password errada)");
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Autenticação falhada. (Utilizador não encontrado)");
        }
    }
}