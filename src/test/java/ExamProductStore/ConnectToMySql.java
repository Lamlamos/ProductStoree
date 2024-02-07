package ExamProductStore;

import java.sql.*;
import java.util.HashMap;


public class ConnectToMySql {




    public HashMap connectTo() throws ClassNotFoundException {
     Config config = new Config();
    HashMap<Integer ,Product> productHM= new HashMap<>();
    String sqlSelectAllPersons = "select * from Categories";
    String connectionUrl = config.getProperties("url");
    String username = config.getProperties("username");
    String password = config.getProperties("password");


        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(connectionUrl,username ,password);
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
             ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String categoryName = rs.getString("Category_name");
                    String deviceName = rs.getString("Device_name");
                    int devicePrice = rs.getInt("Device_price");

                    productHM.put(id , new Product(id , categoryName , deviceName , devicePrice));

                }
            } catch (SQLException e) {
            System.out.println(e); // print the exception
            }

        return productHM;
}
}