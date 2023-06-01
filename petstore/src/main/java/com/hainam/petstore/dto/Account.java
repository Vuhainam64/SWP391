package com.hainam.petstore.dto;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Account implements Serializable {

    private static final String HASH_ALGORITHM = "SHA-256";

    private int accountId;
    private String userName;
    private String accountPassword; // Hashed password
    private String email;
    private String accountRole;
    private int userId;

    public void setPassword(String password) {
        // Hash the password and store it in the accountPassword field
        this.accountPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        try {
            // Create a MessageDigest object with SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);

            // Convert the password to a byte array
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hex string for storage
            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the hashing algorithm is not available
            e.printStackTrace();
            return null;
        }
    }

    public String getPassword() {
        return accountPassword;
    }

}
