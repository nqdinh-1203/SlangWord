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


    static SWDict read(String file_name) throws IOException
    {
        if (!existedFile(file_name))
            return null;

        BufferedReader buffer = new BufferedReader(new FileReader(file_name));
        SWDict dict = new SWDict();
        
        buffer.readLine();
        String line = buffer.readLine();

        while(line != null)
        {
            SlangWord sl = new SlangWord(line);
            dict.add(sl);
            line = buffer.readLine();
        }

        buffer.close();
        return dict;
    }

    static void write(String file_name, SWDict dict)throws IOException
    {
        if (!existedFile(file_name))
            return;

        BufferedWriter buffer = new BufferedWriter(new FileWriter(file_name));
        
        buffer.close();
    }

    /* static void writeSlangWord(String file_name, SlangWord sw) throws IOException
    {
        PrintWriter pout = new PrintWriter(new FileWriter(file_name, true));
        pout.append(sw.toString() + "\n");
        pout.close();
    } */
}
