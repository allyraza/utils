package aeroasync;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkhanwalkar on 3/5/16.
 */
public class TestDriver {

    AeroWriter writer = new AeroWriter();

    public static void main(String[] args) throws Exception {
        TestDriver driver = new TestDriver();

        driver.drive();

        Thread.sleep(1000);
    }

    public void drive()
    {

        Profile profile = createProfile();
        writer.awrite(profile);

    }




    private Profile createProfile()
    {
        Profile profile = new Profile();

        return profile ;

    }



}
