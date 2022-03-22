import java.util.*;

public class SWList {
    private TreeMap<String, ArrayList<String>> dictionary;

    public SWList()
    {
        dictionary = new TreeMap<String, ArrayList<String>>();
    }

    public SWList(TreeMap<String, ArrayList<String>> dict)
    {
        this.dictionary = new TreeMap<String, ArrayList<String>>(dict);
    }

    public SlangWord toSlangWord(Map.Entry<String, ArrayList<String>> entry) {
        return new SlangWord(entry.getKey(), entry.getValue());
    }

    public void add(SlangWord sl)
    {
        this.dictionary.put(sl.getSlang(), sl.getMeanings());
    }

    public void print()
    {
        
    }
}
