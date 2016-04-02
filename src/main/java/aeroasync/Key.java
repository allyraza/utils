package aeroasync;

import java.util.UUID;

/**
 * Created by mkhanwalkar on 3/5/16.
 */
public class Key {

    UUID id ;

    public Key()
    {
        this.id = Randomizer.getInstance().getRandomUUID();

    }
}
