package Task2;

import java.sql.*;

public class JDBC_Task {

    // Connection parameters
    static final String url = "jdbc:mysql://localhost:3306/Empl";
    static final String username = "root";
    static final String password = "Password1!";

    // SQL statement to create table
    static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS EMP_DETAILS (" +
            "empcode INT PRIMARY KEY, " +
            "empname VARCHAR(30), " +
            "empage INT, " +
            "esalary INT" +
            ")";

    // SQL statement to display the table data
    static final String QUERY = "SELECT * FROM EMP_DETAILS";

    // SQL statement for multiple row insert
    static  final String INSERT_QUERY = "INSERT INTO EMP_DETAILS (empcode, empname, empage, esalary) " +
            "VALUES (?, ?, ?, ?)";

    // Values to be inserted
    static Object[][] values = {
            {101, "Jenny",25, 10000},
            {102, "Jacky",30,20000},
            {103, "Joe",20,40000},
            {104, "John",40,80000},
            {105, "Shameer",25,90000}
    };

    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create table if not exists
            createTable(connection);

            // Show table data
            System.out.println("Table data before insert:");
            showTableData(connection);

            // Insert multiple rows into the table
            insertMultipleRows(connection);

            // Show table data after insert
            System.out.println("\nTable data after insert:\n");
            showTableData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement()) {
            // Execute the SQL statement
            statement.executeUpdate(CREATE_QUERY);
            System.out.println("\n\nTable EMP_DETAILS created successfully (if not exists).\n");
        }
    }

    private static void showTableData(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QUERY)) {
            System.out.println("\nEMP_DETAILS Table Data:");
            System.out.printf("%-15s %-15s %-15s %-15s\n",
                    "EMPCODE", "EMPNAME", "EMPAGE", "ESALARY");
            System.out.println("---------------------------------------------------------------------");

            // Print table data
            while (resultSet.next()) {
                int empcode = resultSet.getInt("empcode");
                String empname = resultSet.getString("empname");
                int empage = resultSet.getInt("empage");
                int esalary = resultSet.getInt("esalary");

                // Display the retrieved data in tabular format
                System.out.printf("%-15d %-15s %-15d %-15d\n", empcode, empname, empage, esalary);
            }
        }
    }

    private static void insertMultipleRows(Connection connection) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            // Inserting multiple rows
            for (Object[] row : values) {
                preparedStatement.setInt(1, (int) row[0]);
                preparedStatement.setString(2, (String) row[1]);
                preparedStatement.setInt(3, (int) row[2]);
                preparedStatement.setInt(4, (int) row[3]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("\nInserted " + values.length + " rows successfully.");
        }
    }
}
