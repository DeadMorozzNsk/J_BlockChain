package com.simplechain.webapp.backend.models;

import com.simplechain.webapp.backend.utils.Encryptor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Defines transaction object.
 */
@Entity
@Table(name = "transactions")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Transaction {
    /**
     * Unique transaction id
     */
    @Id
    private String id;
    /**
     * Amount of coins to be sent.
     */
    private double amount;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, insertable = false, updatable = false)
    private WebUser sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false, insertable = false, updatable = false)
    private WebUser receiver;

    /**
     * Constructor.
     *
     * @param pSender   sender's account address
     * @param pReceiver receiver's account address
     * @param pAmount   amount of coins to be sent
     */
    public Transaction(final String pSender,
                       final String pReceiver,
                       final double pAmount) {
        this.id = "Tx_" + Encryptor.getSHA256String(pSender + pReceiver + pAmount);
        if (pAmount <= 0) {
            this.amount = 0;
        } else this.amount = pAmount;
    }

}
