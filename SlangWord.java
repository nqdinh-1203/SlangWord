import java.util.*;

/**
 * SlangWord
 */
public class SlangWord {
    private String slang;
    private List<String> meanings;

    public SlangWord()
    {
        slang = "";
        meanings = new ArrayList<>();
    }

    public SlangWord(String data)
    {
        // tach slang voi meaning qua ki tu "`" vi du: #1`Number one
        String[] s = data.split("`");

        slang = s[0];

        // tach ra cac meaning neu co nhieu meaning
        String[] s1 = s[1].split("| ");

        for (String meaning : s1)
            meanings.add(meaning);
    }
    
    public SlangWord(String slang, List<String> meanings)
    {
        this.slang = slang;
        this.meanings = new ArrayList<>(meanings);
    }

    public String toString()
    {
        String m = "";
        int i;
        for (i = 0; i < meanings.size() - 1; i++) 
        {
            m += meanings.get(i) + "| ";
        }
        m += meanings.get(i);

        return slang + "`" + m;
    }
}