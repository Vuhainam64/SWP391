package com.hainam.petstore.dao;

import com.hainam.petstore.dto.Feedback;
import com.hainam.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {

    private static FeedbackDao instance;
    private Connection conn;

    private FeedbackDao() {
        conn = DBUtil.makeConnection();
    }

    public static FeedbackDao getInstance() {
        if (instance == null) {
            instance = new FeedbackDao();
        }
        return instance;
    }

    public void createFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (message, author) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, feedback.getMessage());
            statement.setString(2, feedback.getAuthor());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Feedback feedback = new Feedback();
                    feedback.setFeedbackId(resultSet.getInt("feedbackId"));
                    feedback.setMessage(resultSet.getString("message"));
                    feedback.setAuthor(resultSet.getString("author"));
                    feedbacks.add(feedback);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return feedbacks;
    }
}
