package source;

import java.io.IOException;
import java.util.*;

public class Features 
{
    public static void f01(SWDict dict, Scanner in) throws IOException
    {
        System.out.print("Input slang for search: ");
        String slang = in.nextLine();

        SlangWord sw = dict.findBySlang(slang);
        if (sw == null) 
        {
            System.out.println("Not Found!");
            ArrayList<String> m = new ArrayList<>();
            m.add("Not Found");
            SlangWord notFound = new SlangWord(slang, m);

            SWFile.writeHistory("history.txt", notFound);
            return;
        }
        System.out.println("Found!");
        sw.print();
        SWFile.writeHistory("history.txt", sw);
    }

    public static void f02(SWDict dict, Scanner in) throws IOException
    {
        System.out.print("Input definition for search: ");
        String meaning = in.nextLine();

        ArrayList<SlangWord> list = dict.findByMeaning(meaning);
        if (list.size() == 0) {
            System.out.println("Not Found!");
            String slang = "Not Found";
            ArrayList<String> m = new ArrayList<>();
            m.add(meaning);
            SlangWord notFound = new SlangWord(slang, m);

            SWFile.writeHistory("history.txt", notFound);
            return;
        }
        System.out.println("Found!");
        for (SlangWord sw : list) {
            sw.print();
            SWFile.writeHistory("history.txt", sw);
        }
    }

    public static void f03() throws IOException
    {
        System.out.println("\n[*] History list:");
        ArrayList<SlangWord> history = SWFile.readHistory("history.txt");

        if(history == null)
            return;

        for (SlangWord sw : history) {
            sw.print();
        }
    }

    public static void f04(SWDict dict, Scanner in, String file_name) throws IOException
    {
        System.out.print("Input slang: ");
        String slang = in.nextLine();

        System.out.print("Input number of meanings: ");
        int num = in.nextInt();
        in.nextLine();

        ArrayList<String> meanings = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.print("Input meaning: ");
            String meaning = in.nextLine();
            meanings.add(meaning);
        }

        SlangWord sw = new SlangWord(slang, meanings);

        if(dict.findBySlang(slang) != null)
        {
            System.out.println("This slang word has been existed!");
            int choice = -1;

            while (choice < 0 || choice > 2) {
                System.out.println("Do you want to 1.Overwrite/2.Duplicate/0.Nothing ?");
                System.out.print("Input your choice: ");
                choice = in.nextInt();
                in.nextLine();
            }
            
            switch (choice) {
                case 1:
                    dict.deleteSlangWord(slang);
                    dict.add(sw);
                    System.out.println("Add slang word successfully!");
                    SWFile.write(file_name,  dict);
                    break;
                case 2:
                    dict.duplicateSlangWord(sw);
                    System.out.println("Add slang word successfully!");
                    SWFile.write(file_name,  dict);
                    break;
                default:
                    break;
            }
            return;
        }
        dict.add(sw);
        System.out.println("Add slang word successfully!");
        SWFile.write(file_name,  dict);
    }

    public static void f05(SWDict dict, Scanner in, String file_name) throws IOException
    {
        System.out.print("Input slang: ");
        String slang = in.nextLine();

        if(dict.findBySlang(slang) == null)
        {
            System.out.println("This slang word has not been existed! Edit Failed!");
            return;
        }

        System.out.print("Input number of meanings: ");
        int num = in.nextInt();
        in.nextLine();

        ArrayList<String> meanings = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.print("Input meaning: ");
            String meaning = in.nextLine();
            meanings.add(meaning);
        }

        SlangWord sw = new SlangWord(slang, meanings);
        dict.editSlangWord(sw);
        System.out.println("Edit Successfully!");
        SWFile.write(file_name,  dict);
    }

    public static void f06(SWDict dict, Scanner in, String file_name) throws IOException
    {
        System.out.print("Input slang: ");
        String slang = in.nextLine();

        if(dict.findBySlang(slang) == null)
        {
            System.out.println("This slang word has not been existed! Delete Failed!");
            return;
        }

        String choice = "";
        while(true)
        {
            System.out.print("Are you sure delete this slang word? (Y/N) ");
            choice = in.nextLine();
            if(choice.equals("y") || choice.equals("Y") || choice.equals("n") || choice.equals("N"))
                break;
        }
        
        if(choice.equals("y") || choice.equals("Y"))
        {
            dict.deleteSlangWord(slang);
            System.out.println("Delete Successfully!");
            SWFile.write(file_name,  dict);
            return;
        }
        System.out.println("Delete Failed!");
    }

    public static void f07(SWDict dict, String file_name) throws IOException
    {
        dict = SWFile.read("default.txt");
        SWFile.write(file_name, dict);
    }

    public static void f08(SWDict dict)
    {
        dict.randomSlangWord().print();
    }

    static boolean checkExisted(ArrayList<SlangWord> list, SlangWord sw)
    {
        for (SlangWord s : list) 
        {
            if (s.getSlang() == sw.getSlang()) {
                return true;
            }    
        }
        return false;
    }

    public static void f09(SWDict dict, Scanner in)
    {
        ArrayList<SlangWord> sw_list = new ArrayList<>();
        SlangWord temp;

        // Random list conclue of 4 different slang words for the game
        for (int i = 0; i < 4; i++) {
            do {
                temp = dict.randomSlangWord();
            } while(checkExisted(sw_list, temp));
            sw_list.add(temp);
        }
        // shuffle list
        Collections.shuffle(sw_list);

        Random gen = new Random();
        int randomIndex = gen.nextInt(sw_list.size());
        SlangWord answer = sw_list.remove(randomIndex);

        // get all meanings of list
        ArrayList<String> all_meanings = new ArrayList<>();

        for (SlangWord s : sw_list) {
            all_meanings.addAll(s.getMeanings());
        }
        
        ArrayList<String> question = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomIndex = gen.nextInt(all_meanings.size());
            question.add(all_meanings.remove(randomIndex));
        }
        question.addAll(answer.getMeanings());
        Collections.shuffle(question);

        System.out.println("What is " + answer.getSlang() + "?");
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + ". " + question.get(i));
        }

        int choice = -1;
        do{
            System.out.print("Input your answer: ");
            choice = in.nextInt();
            in.nextLine();
        }while(choice < 1 || choice > 4);

        if(dict.checkSlangWord(answer.getSlang(), question.get(choice - 1)))
        {
            System.out.print("Correct!");
            return;
        }
        System.out.print("Wrong! The answer is ");
        answer.print();
    }

    public static void f10(SWDict dict, Scanner in)
    {
        ArrayList<SlangWord> sw_list = new ArrayList<>();
        SlangWord temp;

        for (int i = 0; i < 4; i++) {
            do {
                temp = dict.randomSlangWord();
            } while(checkExisted(sw_list, temp));
            sw_list.add(temp);
        }
        Collections.shuffle(sw_list);

        Random gen = new Random();
        int randomIndex = gen.nextInt(sw_list.size());
        SlangWord answer = sw_list.get(randomIndex);

        randomIndex = gen.nextInt(answer.getMeanings().size());
        String meaning_answer = answer.getMeanings().get(randomIndex);

        System.out.println("What is " + meaning_answer + "?");
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + ". " + sw_list.get(i).getSlang());
        }
        
        int choice = -1;
        do{
            System.out.print("Input your answer: ");
            choice = in.nextInt();
            in.nextLine();
        }while(choice < 1 || choice > 4);

        if(dict.checkSlangWord(sw_list.get(choice - 1).getSlang(), meaning_answer))
        {
            System.out.println("Correct!");
            return;
        }
        System.out.print("Wrong! The answer is ");
        answer.print();
    }

    public static void f11() throws IOException
    {  
        SWFile.clearHistory("history.txt");
    }
}
