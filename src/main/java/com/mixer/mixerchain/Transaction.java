package com.mixer.mixerchain;

import com.sun.istack.internal.NotNull;

/**
 * Defines transaction object.
 */

public class Transaction {
    /**
     * Sender's account address.
     */
    private final String sender;
    /**
     * Receiver's account address.
     */
    private final String receiver;
    /**
     * Amount of coins to be sent.
     */
    private final double amount;

    /**
     * Constructor.
     *
     * @param pSender   sender's account address
     * @param pReceiver receiver's account address
     * @param pAmount   amount of coins to be sent
     */
    public Transaction(@NotNull final String pSender,
                       @NotNull final String pReceiver,
                       final double pAmount) {
        if (pAmount <= 0) {
            throw new IllegalArgumentException(
                    "Amount of coins can not be less than 0!!!");
        }
        this.sender = pSender;
        this.receiver = pReceiver;
        this.amount = pAmount;
    }

    /**
     * Returns sender's account address.
     *
     * @return <String> account address
     */
    public String getSender() {
        return sender;
    }

    /**
     * Returns receiver's account address.
     *
     * @return <String> account address
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Returns amount of coins to be sent from sender to receiver.
     *
     * @return amount of coins
     */
    public double getAmount() {
        return amount;
    }
}
