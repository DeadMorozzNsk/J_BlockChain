package com.mixer.mixerchain.database;

import com.mixer.mixerchain.Block;
import com.mixer.mixerchain.Transaction;

import java.sql.*;
import java.text.SimpleDateFormat;

public class SQLiteInteractor implements DatabaseInteractor {
    private Connection connection;
    private Statement stmt;

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:" + subprotocol + ":" + dbPath);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect(String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:" + subprotocol + ":" + dbPath, login, password);
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
    public void writeBlock(final Block block) {
        if (connection != null) {
            Transaction[] transactions = block.getTransactions();
            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("SELECT");
            for (int i = 0; i < transactions.length; i++) {
                sqlQuery.append("INSERT INTO transactions(block_id, sender_id, receiver_id, timestamp, amount)\n" +
                        "VALUES(" + 1 /** need to blockId */+ ", \"" +
                        transactions[i].getSender() + "\", \"" +
                        transactions[i].getReceiver() + "\", \"" +
                        new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new java.util.Date()) + "\", " +
                        transactions[i].getAmount() + ");");
            }
        }
    }

    @Override
    public void getTransaction(final String transactionId) {

    }

    @Override
    public void getCurrentBalance(String accountId) {
        
    }
}
