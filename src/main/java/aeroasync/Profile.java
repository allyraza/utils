package aeroasync;

/**
 * Created by mkhanwalkar on 3/5/16.
 */
public class Profile {

    final String name ;
    final String id ;
    final String address ;
    long lastUpdate;

    public Profile()
    {
        this.name = Randomizer.getInstance().getRandomString(10,false);
        this.address = Randomizer.getInstance().getRandomString(20,false);
        this.id = Randomizer.getInstance().getRandomString(30,true);
        this.lastUpdate = System.nanoTime();

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
}
