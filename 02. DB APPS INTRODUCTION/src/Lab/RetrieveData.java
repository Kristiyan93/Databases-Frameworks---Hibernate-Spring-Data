package Lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class RetrieveData {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/diablo?createDatabaseIfNotExist=true&useSSL=false";

        System.out.print("Enter username default (root): ");
        String user = scanner.nextLine();
        user = user.equals("")? "root" : user;

        System.out.print("Enter password default (root): ");
        String password = scanner.nextLine();
        password = password.equals("")? "root" : password;

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection(url, properties);

        PreparedStatement statement = connection
                .prepareStatement(SQL);

        String salary = scanner.nextLine();

        statement.setDouble(1, Double.parseDouble(salary));

        ResultSet resultSet = statement.executeQuery();

        System.out.print("Enter player name: ");
        String userName = scanner.nextLine().trim();

        boolean found = false;

        while (resultSet.next()) {
            found = true;
            System.out.printf("User: %s%n%s has played %d games",
                    userName,
                    resultSet.getString("full_name"),
                    resultSet.getInt("games"));
        }

        if (!found) {
            System.out.println("No such user exists");
        }
    }

    private static final String SQL =
            "" +
                    "SELECT " +
                    "    CONCAT_WS(' ', u.first_name, u.last_name) AS full_name, " +
                    "    COUNT(ug.id) AS games " +
                    "FROM " +
                    "    `diablo`.`users` AS u " +
                    "        JOIN " +
                    "    `diablo`.`users_games` AS ug ON u.id = ug.user_id " +
                    "WHERE " +
                    "    u.user_name = ? " +
                    "GROUP BY u.id;";
}
