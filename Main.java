import source.*;

import java.io.*;
import java.util.*;

public class Main 
{
    static void pause_console(Scanner s)
    {
        System.out.print("\nPress Enter To Continue...");
        s.nextLine();
    }

    public static void main(String[] args) throws IOException
    {
        
        Scanner in = new Scanner(System.in);
        String file_name = "";
        SWDict dict = null;
        
        while(dict == null)
        {
            Menu.ClearConsole();
            System.out.print("Input file name: ");
            file_name = in.nextLine();
            dict = SWFile.read(file_name);
        }

        int choice = -1;

        while (true)
        {
            while (choice < 0 || choice > 11)
            {
                Menu.ClearConsole();
                Menu.mainMenu();
                choice = in.nextInt();
                in.nextLine();
            }
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    Features.f01(dict, in);
                    pause_console(in);
                }
                case 2 -> {
                    Features.f02(dict, in);
                    pause_console(in);
                }
                case 3 -> {
                    Features.f03();
                    pause_console(in);
                }
                case 4 -> {
                    Features.f04(dict, in, file_name);
                    pause_console(in);
                }
                case 5 -> {
                    Features.f05(dict, in, file_name);
                    pause_console(in);
                }
                case 6 -> {
                    Features.f06(dict, in, file_name);
                    pause_console(in);
                }
                case 7 ->{
                    dict.clear();
                    dict = null;
                    dict = Features.f07(file_name);
                    pause_console(in);
                }
                case 8 ->{
                    Features.f08(dict);
                    pause_console(in);
                }
                case 9 ->{
                    Features.f09(dict, in);
                    pause_console(in);
                }
                case 10 ->{
                    Features.f10(dict, in);
                    pause_console(in);
                }
                case 11 ->{
                    Features.f11();
                    pause_console(in);
                }
                default -> {
                }
            }
            choice = -1;
        }
        in.close();
    }
}
