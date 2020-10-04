package MyBlockChain;

import java.sql.Timestamp;
import java.time.Instant;

import static MyBlockChain.Const.ConstValues.CONST_BLOCK_TRANSACTIONS_CAPACITY;

public class Block {
    // private BlockData data;
    private long index;
    private String timeStamp;
    private String hash;
    private String previousHash;
    private String payload;
    private Transaction[] transactions = new Transaction[CONST_BLOCK_TRANSACTIONS_CAPACITY];


    public String getHash() {
        return hash;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public Block(String _prevHash, String _payload) {
        this.index = 1;
        this.previousHash = _prevHash;
        this.payload = _payload;
        this.timeStamp = Timestamp.from(Instant.now()).toString();
    }

}
