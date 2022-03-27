import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        String file_name = "slang.txt";

        /* SWList dict = SWFile.read(file_name);
        dict.print(); */

        SWDict dict = SWFile.read("test.txt");

        String slang = ">.<";
        String meaning = "Frustrated";

        System.out.println(dict.checkSlangWord(slang, meaning));

        //List<SlangWord> list = dict.findByMeaning(meaning);
        /* SlangWord random = dict.randomSlangWord();

        System.out.println(random.toString()); */
    }
}
