import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String file_name = "slang.txt";

        /* SWList dict = SWFile.read(file_name);
        dict.print(); */

        SWDict dict = SWFile.read("test.txt");

        Features.f01(dict, in);

        /* String slang = ">.<";
        String meaning = "Frustrated";

        System.out.println(dict.checkSlangWord(slang, meaning)); */

        //List<SlangWord> list = dict.findByMeaning(meaning);
        /* SlangWord random = dict.randomSlangWord();

        System.out.println(random.toString()); */
        in.close();
    }
}
