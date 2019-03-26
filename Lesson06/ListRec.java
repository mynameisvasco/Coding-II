import java.io.*;

public class ListRec
{
    public static void main(String[] args)
    {
        assert args.length == 1 : "Argumentos em falta. java -ea ListRec directory";
        String directoryName = args[0];
        listDirFiles(directoryName);
    }

    public static void listDirFiles(String directoryName)
    {
        File curDirectory = new File(directoryName);
        
        if(curDirectory.isDirectory())
        {
            for(int i = 0; i < curDirectory.listFiles().length; i++)
            {
                System.out.println(curDirectory.listFiles()[i].getPath());
                listDirFiles(curDirectory.listFiles()[i].getPath());
            }
        }
        else
        {
            System.out.println(curDirectory.getPath());
        }
    }
}