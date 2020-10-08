import com.mixer.mixerchain.encryption.Encryption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlockChainTest {
    @Test
    void encryption_test(){
        Encryption myCrypt = new Encryption("hjgk");
        String testStr = "test";

        String encoded = myCrypt.encode(testStr);
        Assertions.assertEquals("8432d9a67aeb937384320f6b7eab7eab", encoded);
        Assertions.assertEquals(testStr, myCrypt.decode(encoded));
    }
}
