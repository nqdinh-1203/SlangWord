import java.util.Scanner;

public class Features 
{
    static void f01(SWDict dict, Scanner in)
    {
        System.out.print("Input slang for search: ");
        String slang = in.nextLine();

        SlangWord sw = dict.findBySlang(slang);
        if (sw == null) 
        {
            System.out.println("Not Found!\n");
            return;
        }
        System.out.println("Found!\n" + sw.toString());
    }

}
