import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        SWList dict = new SWList();
        String file_name = "slang.txt";

        SWFile.read(file_name, dict);

        System.out.println(dict);
    }
}
