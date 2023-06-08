package com.hainam.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hainam.petstore.dto.Account;
import com.hainam.petstore.util.DBUtil;

public class AccountDao {

    private static AccountDao instance;
    private Connection conn;

    private AccountDao() {
        conn = DBUtil.makeConnection();
    }

    public static AccountDao getInstance() {
        if (instance == null) {
            instance = new AccountDao();
        }
        return instance;
    }

    public void createAccount(Account account) {
        String query = "INSERT INTO account (userName, accountPassword, email, accountRole, userId) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, account.getUserName());
            statement.setString(2, account.getPassword()); // Use the hashed password
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getAccountRole());
            statement.setInt(5, account.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public Account getAccountById(int accountId) {
        String query = "SELECT * FROM account WHERE accountId = ?";
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, accountId);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToAccount(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM account";
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = mapResultSetToAccount(resultSet);
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return accounts;
    }

    public void updateAccount(Account account) {
        String query = "UPDATE account SET userName = ?, accountPassword = ?, email = ?, accountRole = ?, userId = ? WHERE accountId = ?";
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, account.getUserName());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getAccountRole());
            statement.setInt(5, account.getUserId());
            statement.setInt(6, account.getAccountId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public void deleteAccount(int accountId) {
        String query = "DELETE FROM account WHERE accountId = ?";
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, accountId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public Account getAccountByUserName(String userName) {
    String query = "SELECT * FROM account WHERE userName = ?";
    try (PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, userName);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return mapResultSetToAccount(resultSet);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception as needed
    }

    return null;
}

    
    
    private Account mapResultSetToAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setAccountId(resultSet.getInt("accountId"));
        account.setUserName(resultSet.getString("userName"));
        account.setAccountPassword(resultSet.getString("accountPassword"));
        account.setEmail(resultSet.getString("email"));
        account.setAccountRole(resultSet.getString("accountRole"));
        account.setUserId(resultSet.getInt("userId"));
        return account;
    }
}
