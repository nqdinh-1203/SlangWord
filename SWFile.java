import java.io.*;

public class SWFile 
{
    static boolean existedFile(String file_name)
    {
        File f = new File(file_name);

        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        System.out.println("\nERROR: File does not existed!");
        return false;
    }


    public static void read(String file_name, SWList dict) throws IOException
    {
        if (!existedFile(file_name)) {
            return;
        }
        BufferedReader buffer = new BufferedReader(new FileReader(file_name));
        dict = new SWList();
        
        String line = "";
        buffer.readLine();

        while((line = buffer.readLine()) != null)
        {
            SlangWord sl = new SlangWord(line);
            dict.add(sl);
        }

        buffer.close();
    }

    public void write(String file_name)
    {

    }
}
