import java.io.*;

public class ListDir
{
    public static void main(String[] args) throws IOException
    {
        //Verificar o número de argumentos
        if(args.length == 0)
        {
            //Caso não existam argumentos mostrar listagem do directório atual
            File currentDir = new File(".");

            for(int i = 0; i < currentDir.listFiles().length; i++)
            {
                //Mostrar se o caminho é diretório ou ficheiro
                if(currentDir.listFiles()[i].isFile())
                {
                    System.out.print("F");
                }
                else if(currentDir.listFiles()[i].isDirectory())
                {
                    System.out.print("D");
                }
                else
                {
                    continue;
                }

                //Mostrar as permissões do caminho
                if(currentDir.listFiles()[i].canRead())
                {
                    System.out.print("R");
                }
                else
                {
                    System.out.print("-");
                }


                if(currentDir.listFiles()[i].canWrite())
                {
                    System.out.print("W");
                }
                else
                {
                    System.out.print("-");
                }

                System.out.println(" " + currentDir.listFiles()[i]);
            }
        }
        else if(args.length == 1)
        {
            //Caso existam argumentos mostrar listagem do diretório fornecido como argumento
            //Caso não existam argumentos mostrar listagem do directório atual
            File currentDir = new File(args[0]);

            if(currentDir.exists())
            {
                for(int i = 0; i < currentDir.listFiles().length; i++)
                {
                    //Mostrar se o caminho é diretório ou ficheiro
                    if(currentDir.listFiles()[i].isFile())
                    {
                        System.out.print("F");
                    }
                    else if(currentDir.listFiles()[i].isDirectory())
                    {
                        System.out.print("D");
                    }
                    else
                    {
                        continue;
                    }

                    //Mostrar as permissões do caminho
                    if(currentDir.listFiles()[i].canRead())
                    {
                        System.out.print("R");
                    }
                    else
                    {
                        System.out.print("-");
                    }


                    if(currentDir.listFiles()[i].canWrite())
                    {
                        System.out.print("W");
                    }
                    else
                    {
                        System.out.print("-");
                    }
                    
                    System.out.println(" " + currentDir.listFiles()[i]);
                }
            }
            else
            {
                System.out.println("Caminho inexistente");
            }
        }
    }
}
