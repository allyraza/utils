package aeroasync;

import java.util.Random;
import java.util.UUID;

public class Randomizer {


    private Randomizer()
    {

    }


    public static Randomizer getInstance()
    {
        return Holder.randomizer;
    }



    public UUID getRandomUUID()
    {
        return UUID.randomUUID();
    }



    public String getRandomString(int length, boolean caps)
    {
        int offset ;
        if (caps)
        {
            offset = 65;
        }
        else
        {
            offset = 97;
        }


        StringBuilder builder = new StringBuilder(length);
        for (int i=0;i<length;i++)
        {
            char c = (char)(random.nextInt(26)+offset);
            builder.append(c);
        }

        return builder.toString();

    }


    Random random = new Random(System.nanoTime());

    static class Holder
    {
        static Randomizer randomizer = new Randomizer();
    }


}
