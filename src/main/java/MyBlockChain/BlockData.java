package MyBlockChain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Base64;

public class BlockData {
    private long index;
    private String timeStamp;
    private String hash;
    private String previousHash;
    private String payload;

    public BlockData(String _prevHash, String _payload){
        this.index = 1;
        this.previousHash = _prevHash;
        this.payload = _payload;
        this.timeStamp = Timestamp.from(Instant.now()).toString();
    }

    public String getHash() {
       return hash;
    }
}
