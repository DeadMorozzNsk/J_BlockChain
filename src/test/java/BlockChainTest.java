import com.mixer.webapp.backend.utils.Encryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockChainTest {
    @Test
    void encryptionTest(){
        Encryptor myCrypt = new Encryptor("hjgk");
        String testStr = "test";

        String encoded = myCrypt.encode(testStr);
        Assertions.assertEquals("8432d9a67aeb937384320f6b7eab7eab", encoded);
        Assertions.assertEquals(testStr, myCrypt.decode(encoded));
    }

    @Test
    void hashTest(){
        Assertions.assertEquals("f0e4c2f76c58916ec258f246851bea091d14d4247a2fc3e18694461b1816e13b",
                Encryptor.getSHA256String("asdf"));
    }
}
