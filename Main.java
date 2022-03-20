import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        String slang = "=)))))";
        List<String> meanings = new ArrayList<>();
        meanings.add("slime");
        meanings.add("more slime");
        meanings.add("more than slime");
    
        SlangWord sl = new SlangWord(slang, meanings);

        System.out.println(sl.toString());
    }
    
}
