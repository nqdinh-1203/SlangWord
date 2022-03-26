import java.util.*;

public class SWDict {
    private TreeMap<String, ArrayList<String>> dictionary;

    public SWDict()
    {
        dictionary = new TreeMap<String, ArrayList<String>>();
    }

    public SWDict(TreeMap<String, ArrayList<String>> dict)
    {
        this.dictionary = new TreeMap<String, ArrayList<String>>(dict);
    }

    public SlangWord toSlangWord(Map.Entry<String, ArrayList<String>> entry) 
    {
        return new SlangWord(entry.getKey(), entry.getValue());
    }

    public void add(SlangWord sl)
    {
        this.dictionary.put(sl.getSlang(), sl.getMeanings());
    }

    public void print()
    {
        Set<Map.Entry<String, ArrayList<String>>> set = dictionary.entrySet();
        System.out.println(dictionary.size());

        for (Map.Entry<String, ArrayList<String>> sl : set) {
            SlangWord temp = toSlangWord(sl);
            System.out.println(temp.toString());
        }
    }
}
