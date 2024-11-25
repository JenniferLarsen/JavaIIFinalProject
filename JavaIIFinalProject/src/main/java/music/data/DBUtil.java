/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author djlar
 */
public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/music_jpa";  // Replace with your DB URL
        String username = "root";  // Replace with your DB username
        String password = "sesame";  // Replace with your DB password
        return DriverManager.getConnection(url, username, password);
    }
}
