package aeroasync;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mkhanwalkar on 3/5/16.
 */
public class Profile {

    final String name ;
    final String id ;
    final String address ;
    long lastUpdate;

    static ObjectMapper mapper = new ObjectMapper();

    public Profile()
    {
        this.name = Randomizer.getInstance().getRandomString(10,false);
        this.address = Randomizer.getInstance().getRandomString(20,false);
        this.id = Randomizer.getInstance().getRandomString(30,true);
        this.lastUpdate = System.nanoTime();

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public String toJSon()
    {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
