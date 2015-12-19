package translate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mkhanwalkar on 12/18/15.
 */
public class Data {

     String type ;
    String values ;
    String[] componentVersion;

    String[] commponentVersionValues;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String[] getComponentVersion() {
        return componentVersion;
    }

    public void setComponentVersion(String[] componentVersion) {
        this.componentVersion = componentVersion;
    }

    public String[] getCommponentVersionValues() {
        return commponentVersionValues;
    }

    public void setCommponentVersionValues(String[] commponentVersionValues) {
        this.commponentVersionValues = commponentVersionValues;
    }

    public static void main(String[] args) throws Exception  {
        Data d = new Data();
        d.setType("Gender");
        d.setValues("M,F");
        String[] s1 = {"C1V1", "C2V1"};
        String[] s2 = {"Male:Female", "m:f"};
        d.setComponentVersion(s1);
        d.setCommponentVersionValues(s2);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(d));
    }

}
