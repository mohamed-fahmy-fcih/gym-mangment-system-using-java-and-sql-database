package sample.admin.AddAdminWindow;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AddAdminWindow implements Initializable {
    String jsonPathFile = "jsonFile.json";

    public TextField addNameTextF;
    public TextField addAgeTextF;
    public TextField addWightTextF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addAgeTextF.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}(\\d{0,4})?")) {
                addAgeTextF.setText(oldValue);
            }
        });
    }

    public void addMemberBtn(Event event)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "root", "1912002");
            System.out.println("Connection Succ!");

            String sql = "INSERT INTO members (name, age, weight) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, addNameTextF.getText());
            preparedStatement.setInt(2, Integer.parseInt(addAgeTextF.getText()));
            preparedStatement.setInt(3, Integer.parseInt(addWightTextF.getText()));

            preparedStatement.execute();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

    }
}
