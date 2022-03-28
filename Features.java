import java.io.IOException;
import java.util.*;

public class Features 
{
    static void f01(SWDict dict, ArrayList<SlangWord> history, Scanner in) throws IOException
    {
        System.out.print("Input slang for search: ");
        String slang = in.nextLine();

        SlangWord sw = dict.findBySlang(slang);
        if (sw == null) 
        {
            System.out.println("Not Found!\n");
            return;
        }
        System.out.println("Found!");
        sw.print();
        history.add(sw);
    }

    static void f02(SWDict dict, ArrayList<SlangWord> history, Scanner in) throws IOException
    {
        System.out.print("Input definition for search: ");
        String meaning = in.nextLine();

        ArrayList<SlangWord> list = dict.findByMeaning(meaning);
        if (list.size() == 0) {
            System.out.println("Not Found!\n");
            return;
        }
        System.out.println("Found!");
        for (SlangWord sw : list) {
            sw.print();
            history.add(sw);
        }
    }

    static void f03(ArrayList<SlangWord> history) throws IOException
    {
        System.out.println("\nHistory list:");
        for (SlangWord sw : history) {
            sw.print();
        }
    }

    static void f04(SWDict dict, Scanner in)
    {
        
    }
    static void f05(SWDict dict, Scanner in){}
    static void f06(SWDict dict, Scanner in){}
    static void f07(SWDict dict, Scanner in){}
    static void f08(SWDict dict, Scanner in){}
    static void f09(SWDict dict, Scanner in){}
    static void f10(SWDict dict, Scanner in){}
}
