package MyBlockChain.Database;

import MyBlockChain.Block;

import java.sql.SQLException;

import static MyBlockChain.Const.ConstValues.CONST_DATABASE_URL;
import static MyBlockChain.Const.ConstValues.CONST_JDBC_SUBPROTOCOL;

public interface DatabaseInteractor {
    String dbPath = CONST_DATABASE_URL;
    String subprotocol = CONST_JDBC_SUBPROTOCOL;

    void connect() throws SQLException;

    void connect(String login, String password) throws SQLException;

    void disconnect();

    void writeBlock(Block block) throws SQLException;

    void getTransaction(String transaction_id) throws SQLException;


}
