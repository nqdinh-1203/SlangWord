import java.util.*;
import java.util.Map.Entry;

public class SWDict {
    //Attributes=====================================================
    private TreeMap<String, ArrayList<String>> dictionary;

    //Method=========================================================

    //===================CONSTRUCTORS=========================
    public SWDict()
    {
        dictionary = new TreeMap<String, ArrayList<String>>();
    }

    public SWDict(TreeMap<String, ArrayList<String>> dict)
    {
        this.dictionary = new TreeMap<String, ArrayList<String>>(dict);
    }
    //===========================================================================

    //=================== HELPER ================================================
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
        System.out.println(dictionary.size());

        for (Map.Entry<String, ArrayList<String>> sl : dictionary.entrySet()) {
            SlangWord temp = toSlangWord(sl);
            System.out.println(temp.toString());
        }
    }
    
    public SlangWord findBySlang(String slang) {
        for (Map.Entry<String, ArrayList<String>> sl : dictionary.entrySet()) {
            if(sl.getKey().equals(slang))
                return toSlangWord(sl);
        }
        return null;
    }

    public List<SlangWord> findByMeaning(String meaning) {
        List<SlangWord> list = new ArrayList<SlangWord>();

        for (Map.Entry<String, ArrayList<String>> sl : dictionary.entrySet()) 
        {
            for(String m : sl.getValue())
                if(m.contains(meaning))
                    list.add(toSlangWord(sl));
        }

        return list;
    }

    public void addSlangWord(SlangWord sw)
    {
        dictionary.put(sw.getSlang(), sw.getMeanings());
    }

    public void duplicateSlangWord(SlangWord sw, Map.Entry<String, ArrayList<String>> s) 
    {
        ArrayList<String> m = s.getValue();
        m.addAll(sw.getMeanings());
        s.setValue(m);
    }

    public void deleteSlangWord(SlangWord sw) 
    {
        dictionary.remove(sw.getSlang());
    }

    public SlangWord randomSlangWord() {
        Random random = new Random();
        List<String> slangs  = new ArrayList<String>(dictionary.keySet());
        String randomSlang = slangs.get(random.nextInt(slangs.size()));
        ArrayList<String> values = dictionary.get(randomSlang);

        return new SlangWord(randomSlang, values);
    }

    public boolean checkSlangWord(String slang, String meaning) {
        ArrayList<String> meanings = new ArrayList<String>();
        meanings = dictionary.get(slang);

        return meanings.contains(meaning);
    }
}
