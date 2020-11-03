package com.mixer.webapp.backend.models;

import com.mixer.webapp.backend.utils.Encryptor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ResourceBundle;


public class Block {
    private final ResourceBundle resource = ResourceBundle.getBundle("blockchain");
    private long index;
    private String timeStamp;
    private String hash;
    private String previousHash;
    private Transaction[] transactions = new Transaction[
            Integer.parseInt(resource.getString("transactions_per_block"))];


    public String getHash() {
        return hash;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public Block(String _prevHash) {
        this.index = 1;
        this.previousHash = _prevHash;
        this.timeStamp = Timestamp.from(Instant.now()).toString();
    }

    private boolean isValid(Block previousBlock) {
        if (previousBlock.index + 1 != this.index) {
            System.out.println("неверный индекс");
            return false;
        } else if (previousBlock.hash.equals(this.previousHash)) {
            System.out.println("неверный хеш предыдущего блока");
            return false;
        } else if (calculateHashForBlock(this).equals(this.hash)) {
            System.out.println("неверный хеш: " + calculateHashForBlock(this) + ' ' + this.hash);
            return false;
        }
        return true;
    }

    private String calculateHashForBlock(Block block) {
        return Encryptor.getSHA256String(block.previousHash + block.timeStamp + block.index);
    }
}
