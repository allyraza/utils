package translate;

/**
 * Created by mkhanwalkar on 12/18/15.
 */
public class Translator {

    private Translator() {}

    private TranslatorCache cache = TranslatorCache.getInstance();

    public void addDataToCache(Data data)
    {
        cache.add(data);
    }

    public String getTranslation(String type, String CompVer , String value)
    {
        ExpandedData data = cache.get(type);

        if (data!=null) {

            return data.getValue(CompVer, value);
        }
        else
        {
            return value ;
        }

        // String[] s = data.getValues().split(",");
    }

    static class Holder
    {
        static Translator factory = new Translator();
    }

    public static Translator getInstance()
    {
        return Holder.factory;

    }



}
