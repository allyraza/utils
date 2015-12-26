/**
 * Created by mkhanwalkar on 12/25/15.
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;


public class XMLToJSON
{
    public String name;
    public Bar bar;

    public static void main(String[] args) throws Exception
    {
        // JSON input: {"name":"FOO","bar":{"id":42}}
        String jsonInput = "{\"name\":\"XMLToJSON\",\"bar\":{\"id\":42}}";

        ObjectMapper jsonMapper = new ObjectMapper();
        XMLToJSON foo = jsonMapper.readValue(jsonInput, XMLToJSON.class);


        XmlMapper xmlMapper = new XmlMapper();
        System.out.println(xmlMapper.writeValueAsString(foo));
        // <Foo xmlns=""><name>FOO</name><bar><id>42</id></bar></Foo>
    }
}

class Bar
{
    public int id;
}