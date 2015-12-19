package security;

import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;

public class MainClass {


    public static void main(String[] args) {

        try

        {
            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            keyStore.load(null, null);

            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            ;
            Key key = keyGen.generateKey();

            keyStore.setKeyEntry("secret", key, "password".toCharArray(), null);

            keyStore.store(new FileOutputStream("/tmp/output.jceks"), "password".toCharArray());
        } catch (
                Exception ex
                )

        {
            ex.printStackTrace();
        }


        try {
            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            keyStore.load(new FileInputStream("/tmp/output.jceks"), "password".toCharArray());

            Key key = keyStore.getKey("secret", "password".toCharArray());

            System.out.println(key.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}