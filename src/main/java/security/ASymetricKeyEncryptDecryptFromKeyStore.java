package security;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;


public class ASymetricKeyEncryptDecryptFromKeyStore {

static final String KEYSTORE_PASSWORD = "MYPASSWD";


    public static void main(String[] args) throws Exception {

        //TODO - use KeyPAirFileCreator to create the key files before using this .

        ASymetricKeyEncryptDecryptFromKeyStore askedfks = new ASymetricKeyEncryptDecryptFromKeyStore();



     //   byte[] e = asked.rsaEncrypt("HelloWorld".getBytes());

     //   byte[] d = asked.rsaDeEncrypt(e);

//        String s = new String(d);

     //   System.out.println(s);


    }





    public static byte[] rsaEncrypt(byte[] data) throws Exception {
        PublicKey pubKey = readKeyFromFile("/tmp/public.key");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] cipherData = cipher.doFinal(data);
        return cipherData;
    }

    public static byte[] rsaDeEncrypt(byte[] data) throws Exception {
        PrivateKey pubKey = readPrivateKeyFromFile("/tmp/private.key");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        byte[] cipherData = cipher.doFinal(data);
        return cipherData;
    }




    private static PublicKey readKeyFromFile(String keyFileName) throws IOException {

        ObjectInputStream oin =
                new ObjectInputStream(new FileInputStream(keyFileName));
        try {
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PublicKey pubKey = fact.generatePublic(keySpec);
            return pubKey;
        } catch (Exception e) {
            throw new RuntimeException("Spurious serialisation error", e);
        } finally {
            oin.close();
        }
    }

    private static PrivateKey readPrivateKeyFromFile(String keyFileName) throws IOException {

        ObjectInputStream oin =
                new ObjectInputStream(new FileInputStream(keyFileName));
        try {
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PrivateKey pubKey = fact.generatePrivate(keySpec);
            return pubKey;
        } catch (Exception e) {
            throw new RuntimeException("Spurious serialisation error", e);
        } finally {
            oin.close();
        }


    }

}
