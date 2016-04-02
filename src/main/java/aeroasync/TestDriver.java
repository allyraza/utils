package aeroasync;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkhanwalkar on 3/5/16.
 */
public class TestDriver {

    public static void main(String[] args) {
        TestDriver driver = new TestDriver();

        driver.drive();
    }

    public void drive()
    {

List<Key> keys= new ArrayList<>();
        for (int i=0;i<100;i++)
        {
            keys.add(new Key());
        }

        processKeys(keys);


    }

    private void processKeys(List<Key> keys)
    {


    }

    private void getProfiles(Key key)
    {

    }

    private void processProfile()
    {
        // update

    }


    private void createProfiles(Key key)
    {
        Profile profile = new Profile();

    }

}
