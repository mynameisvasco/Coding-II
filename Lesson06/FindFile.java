import java.io.*;

public class FindFile
{
    public static void main(String[] args)
    {
        assert args.length == 2 : "Argumentos em falta. java -ea ListRec findfilename directory";
        String fileName = args[0]; 
        String directoryName = args[1];
        System.out.println("Procurando...");
        findFileInDirectory(directoryName, fileName);
    }

    public static void findFileInDirectory(String directoryName, String fileName)
    {
        File curDirectory = new File(directoryName);
        
        if(curDirectory.isDirectory())
        {
            for(int i = 0; i < curDirectory.listFiles().length; i++)
            {
                if(curDirectory.listFiles()[i].getName().contains(fileName))
                {
                    System.out.println(curDirectory.listFiles()[i].getPath());
                }
                findFileInDirectory(curDirectory.listFiles()[i].getPath(), fileName);
            }
        }
    }
}