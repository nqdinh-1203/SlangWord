package source;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class SWFile 
{
    static boolean existedFile(String file_name)
    {
        File f = new File(file_name);

        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        return false;
    }


    public static SWDict read(String file_name) throws IOException
    {
        file_name = "data/" + file_name;

        if (!existedFile(file_name))
            return null;

        BufferedReader buffer = new BufferedReader(new FileReader(file_name));
        SWDict dict = new SWDict();
        
        buffer.readLine();
        while(true)
        {
            String line = buffer.readLine();
            if(line == null)
                break;

            SlangWord sl = new SlangWord(line);
            dict.add(sl);
        }

        buffer.close();
        return dict;
    }

    public static void write(String file_name, SWDict dict) throws IOException
    {
        file_name = "data/" + file_name;

        BufferedWriter buffer = new BufferedWriter(new FileWriter(file_name));

        buffer.write("Slag`Meaning\n");
        
        for (Map.Entry<String, ArrayList<String>> entry : dict.getEntrySet()) {
            buffer.write(dict.toSlangWord(entry).toString() + "\n");
        }

        buffer.close();
    }

    public static boolean clearHistory(String file_name) throws IOException
    {
        file_name = "data/" + file_name;

        if (!existedFile(file_name))
            return false;

        File history = new File(file_name); 
        return history.delete();
    }

    public static ArrayList<SlangWord> readHistory(String file_name) throws IOException
    {
        file_name = "data/" + file_name;

        if (!existedFile(file_name))
            return null;

        BufferedReader buffer = new BufferedReader(new FileReader(file_name));
        ArrayList<SlangWord> history = new ArrayList<SlangWord>();
        
        while(true)
        {
            String line = buffer.readLine();
            if(line == null)
                break;

            SlangWord sl = new SlangWord(line);
            history.add(sl);
        }

        buffer.close();
        return history;
    }
    
    public static void writeHistory(String file_name, SlangWord sw) throws IOException
    {
        file_name = "data/" + file_name;
        PrintWriter pout = new PrintWriter(new FileWriter(file_name, true));
        pout.append(sw.toString() + "\n");
        pout.close();
    }
}
