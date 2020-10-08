package com.mixer.mixerchain.database;

import com.mixer.mixerchain.Block;

import static com.mixer.mixerchain.permanent.ConstValues.CONST_DATABASE_URL;
import static com.mixer.mixerchain.permanent.ConstValues.CONST_JDBC_SUBPROTOCOL;

public interface DatabaseInteractor {
    String dbPath = CONST_DATABASE_URL;
    String subprotocol = CONST_JDBC_SUBPROTOCOL;

    void connect();

    void connect(String login, String password);

    void disconnect();

    void writeBlock(Block block);

    void getTransaction(String transactionId);

    void getCurrentBalance(String accountId);

}
