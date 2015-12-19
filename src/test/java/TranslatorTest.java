import com.fasterxml.jackson.databind.ObjectMapper;
import translate.Data;
import translate.Translator;

/**
 * Created by mkhanwalkar on 12/18/15.
 */
public class TranslatorTest {

    static String s = "{\"type\":\"Gender\",\"values\":\"M,F\",\"componentVersion\":[\"C1V1\",\"C2V1\"],\"commponentVersionValues\":[\"Male:Female\",\"m:f\"]}";

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Data d = mapper.readValue(s, Data.class);

        Translator translator = Translator.getInstance();
        translator.addDataToCache(d);

       String ans =  translator.getTranslation("Gender","C1V1","M");

        System.out.println(ans);

    }

    // type , Values , C1V1 ,

}
