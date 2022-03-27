import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        String file_name = "slang.txt";

        /* SWList dict = SWFile.read(file_name);
        dict.print(); */

        SWDict dict = SWFile.read("test.txt");

        String slang = ">//<";
        String meaning = "Mischievous Smile";

        

        //List<SlangWord> list = dict.findByMeaning(meaning);
        SlangWord random = dict.randomSlangWord();

        System.out.println(random.toString());
    }
}
