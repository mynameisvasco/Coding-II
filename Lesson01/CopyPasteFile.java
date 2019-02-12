import java.io.*;
import java.util.Scanner;

public class CopyPasteFile
{
    public static void main(String[] args) throws IOException
    {
        if(args.length < 2)
        {
            System.out.println("> ERR: Argumentos em falta");
        }
        else
        {
            File inputFile = new File(args[0]);
            
            if(inputFile.exists() && inputFile.canRead())
            {
                if(inputFile.isDirectory())
                {
                    System.out.println("> ERR: O caminho fornecido é um diretório");
                }
                else
                {
                    Scanner inputFileScanner = new Scanner(inputFile);

                    File outputFile = new File(args[1]);

                    if(outputFile.exists())
                    {
                        System.out.println("> ERR: Já existe um ficheiro com esse nome");
                    }
                    else
                    {
                        outputFile.createNewFile();

                        PrintWriter outputPrintWriter = new PrintWriter(outputFile);

                        while(inputFileScanner.hasNextLine())
                        {
                            String curLine = inputFileScanner.nextLine();
                            outputPrintWriter.println(curLine);
                        }

                        System.out.println("> Ficheiro copiado com sucesso");
                        outputPrintWriter.close();
                    }

                    inputFileScanner.close();
                }
            }   
            else
            {
                System.out.println("> ERR: O arquivo não existe ou não tem permissões de leitura.");
            }
        }
    }
}