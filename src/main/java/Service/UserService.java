package Service;

import Connection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public void insertUser(User user) {
        String insertSql = "insert into user (userName, fullName, password)" + "Values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(insertSql);

        try {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteUser(int id) {
        String deleteSql = "delete from user where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(deleteSql);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //EDIT USER
    public void editUser(int id, User user) throws SQLException {

        String editQuery = "update user set userName=?, fullName=?, password=?," + "where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(editQuery);

        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getFullName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();
    }

    //LOGIN
    public User getUser(String userName, String password) {

        User user = null;
        String query = "select * from user where userName = ?, password=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));

                System.out.println("UserName is : " + userName + " Password is: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
