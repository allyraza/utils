package translate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mkhanwalkar on 12/18/15.
 */
public class ExpandedData {

    List<String> values;
    List<String> componentVersion;
    List<List<String>> componentVersionValues;

    public ExpandedData(Data data) {

        values = new ArrayList<>(Arrays.asList(data.getValues().split(",")));

        componentVersion = new ArrayList<>(Arrays.asList(data.getComponentVersion()));

        componentVersionValues = new ArrayList<>();

        for (String s : data.getCommponentVersionValues())
        {
            componentVersionValues.add(new ArrayList<>(Arrays.asList(s.split(":"))));
        }


    }


    public String getValue(String CompVer , String value)
    {
        try {
            int loc = values.indexOf(value);
            int loc1 = componentVersion.indexOf(CompVer);

            List<String> list = componentVersionValues.get(loc1);
            String s = list.get(loc);

            return s;
        } catch (Exception e )
        {
            e.printStackTrace();
            return value ;
        }
    }
}
