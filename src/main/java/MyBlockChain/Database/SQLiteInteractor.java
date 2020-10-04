package MyBlockChain.Database;

import MyBlockChain.Block;
import MyBlockChain.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteInteractor implements DatabaseInteractor {
    Connection connection;
    Statement stmt;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:" + DatabaseInteractor.subprotocol + ":" + DatabaseInteractor.dbPath);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect(String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:" + DatabaseInteractor.subprotocol + ":" + DatabaseInteractor.dbPath, login, password);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeBlock(Block block) {
        if (connection != null) {
            Transaction[] transactions = block.getTransactions();
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("SELECT");
            for (int i = 0; i < transactions.length; i++) {

            }
        }
    }

    @Override
    public void getTransaction(String transaction_id) {

    }
}
