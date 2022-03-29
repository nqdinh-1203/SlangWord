package source;

import java.util.*;

/**
 * SlangWord
 */
public class SlangWord {
    private String slang;
    private ArrayList<String> meanings;

    //===================CONSTRUCTORS=========================
    public SlangWord()
    {
        slang = "";
        meanings = new ArrayList<>();
    }

    public SlangWord(String data)
    {
        meanings = new ArrayList<>();
        // tach slang voi meaning qua ki tu "`" vi du: #1`Number one
        String[] s = data.split("`");

        slang = s[0];

        // tach ra cac meaning neu co nhieu meaning
        String[] s1 = s[1].split("\\|");

        for (String meaning : s1)
            meanings.add(meaning);
    }
    
    public SlangWord(String slang, List<String> meanings)
    {
        this.slang = slang;
        this.meanings = new ArrayList<>(meanings);
    }
    //=========================================================

    //===================GETTER & SETTER=========================
    public void setSlang(String slang)
    {
        this.slang = slang;
    }

    public String getSlang()
    {
        return this.slang;
    }

    public void setMeanings(ArrayList<String> meanings)
    {
        this.meanings = new ArrayList<>();
        this.meanings.addAll(meanings);
    }

    public ArrayList<String> getMeanings()
    {
        return this.meanings;
    }
    //=========================================================

    //=================== HELPER =========================
    public String toString()
    {
        String m = "";
        int i;
        for (i = 0; i < meanings.size() - 1; i++) 
        {
            m += meanings.get(i) + "|";
        }
        m += meanings.get(i);

        return slang + "`" + m;
    }

    public void print()
    {
        String m = "";
        int i;
        for (i = 0; i < meanings.size() - 1; i++) 
        {
            m += meanings.get(i) + "|";
        }
        m += meanings.get(i);

        System.out.println("Slang: " + slang + " - Meanings: " + m);
    }
}