import java.io.*;
import java.util.Scanner;

public class CopyFile
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        if(args.length == 2)
        {
            assert args.length == 2 : "Falta de argumentos, utilize o comando da seguinte forma java -ea CopyFile Texto1.txt Texto2.txt";
            String inputFileName = args[0];
            String outputFileName = args[1];


            try
            {
                File inputFile = new File(inputFileName);
                File outputFile = new File(outputFileName);
                String canCopy = "s";

                if(!inputFile.exists())
                {
                    String extension = "";

                    int i = inputFileName.lastIndexOf('.');

                    if (i > 0) 
                    {
                        extension = inputFileName.substring(i+1);
                    }
                    
                    if(!extension.equals(".txt"))
                    {
                        System.out.println("O ficheiro de entrada não é um ficheiro de texto");
                        System.exit(0);
                    }
                    
                    System.out.println("Ficheiro de entrada inexistente");
                    System.exit(0);
                }

                if(!inputFile.canRead())
                {
                    System.out.println("Ficheiro de entrada sem permissões de leitura");
                    System.exit(0);
                }

                if(outputFile.exists())
                {
                    assert inputFile.exists() : "Ficheiro de entrada inexistente";
                    assert inputFile.canRead() : "Ficheiro sem permissões de escrita";

                    System.out.print("O ficheiro de saída já existe, deseja sobrescrever o ficheiro? [S] / [N] >");

                    do
                    {
                        canCopy = userInput.nextLine();
                    }
                    while(!canCopy.equals("s") && !canCopy.equals("S") && !canCopy.equals("n") && !canCopy.equals("N"));

                }
                else
                {
                    outputFile.createNewFile();

                    if(!outputFile.canWrite())
                    {
                        System.out.println("Ficheiro de saída sem permissões de escrita");
                        System.exit(0);
                    }

                }

                if(canCopy.equals("S") || canCopy.equals("s"))
                {
                    assert outputFile.exists() : "Ficheiro de saída inexistente";
                    assert outputFile.canWrite() : "Ficheiro de saída sem permissões de escrita";
                    
                    Scanner inputFileScanner = new Scanner(inputFile);
                    FileWriter outputFileWriter = new FileWriter(outputFile);

                    while(inputFileScanner.hasNextLine())
                    {
                        outputFileWriter.write(inputFileScanner.nextLine() + "\n");
                    }

                    System.out.println("Ficheiro copiado com sucesso");

                    inputFileScanner.close();
                    outputFileWriter.close();
                }

            }
            catch(IOException e)
            {
                System.out.println(e);
            }

        }
        else
        {
            System.out.println("Falta de argumentos, utilize o comando da seguinte forma java -ea CopyFile Texto1.txt Texto2.txt");
        }
    }
}