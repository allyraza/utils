package translate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkhanwalkar on 12/18/15.
 */
public class TranslatorCache {

    private TranslatorCache() {}


    static class Holder
    {
        static TranslatorCache factory = new TranslatorCache();
    }

    public static TranslatorCache getInstance()
    {
        return Holder.factory;
    }

    Map<String,ExpandedData> keyData = new HashMap<>();

    public ExpandedData get(String key)
    {
        return keyData.get(key);
    }

    public void add(Data data)
    {
        ExpandedData eData = new ExpandedData(data);
        keyData.put(data.getType(),eData);
    }


}
