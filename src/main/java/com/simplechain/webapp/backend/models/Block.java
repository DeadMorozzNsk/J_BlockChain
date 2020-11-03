package com.simplechain.webapp.backend.models;

import com.simplechain.webapp.backend.utils.Encryptor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "blocks")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(updatable = false)
    private String timeStamp;
    private String hash;
    private String previousHash;

    @OneToMany(mappedBy = "block")
    private List<Transaction> transactions = new ArrayList<>(
            Integer.parseInt(
                    ResourceBundle.getBundle("blockchain")
                    .getString("transactions_per_block")));


    public Block(String _prevHash) {
        this.id = 1;
        this.previousHash = _prevHash;
        this.timeStamp = Timestamp.from(Instant.now()).toString();
    }

    private boolean isValid(Block previousBlock) {
        if (previousBlock.id + 1 != this.id) {
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
        return Encryptor.getSHA256String(block.previousHash + block.timeStamp + block.id);
    }
}
