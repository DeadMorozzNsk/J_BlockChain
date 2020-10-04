package MyBlockChain;

public class Transaction {
    String sender;
    String receiver;
    double amount;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

}
