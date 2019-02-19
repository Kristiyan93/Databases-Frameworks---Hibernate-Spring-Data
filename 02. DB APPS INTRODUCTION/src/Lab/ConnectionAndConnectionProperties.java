package Lab;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionAndConnectionProperties {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/soft_uni?createDatabaseIfNotExist=true&useSSL=false";

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
                .prepareStatement("select first_name, last_name from employees where salary > ?1");

        String salary = scanner.nextLine();

        statement.setDouble(1, Double.parseDouble(salary));

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %s", resultSet.getString("first_name"), resultSet.getString("last_name"));
        }
    }
}
