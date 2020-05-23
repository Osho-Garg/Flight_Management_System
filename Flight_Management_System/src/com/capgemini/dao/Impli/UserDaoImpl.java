package com.capgemini.dao.Impli;

import com.capgemini.dao.Interface.IUserDao;
import com.capgemini.entities.Users;
import com.capgemini.util.MyDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    Connection con = MyDBConnection.getConnection();

    @Override
    public Users addUser(Users u)
    /**
     * Here we add the users in the Users table
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
            ps.setInt(1, u.getUserId());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getUserPassword());
            ps.setLong(4, u.getUserPhone());
            ps.setString(5, u.getUserEmail());
            ps.setString(6, u.getUserType());
            ps.executeUpdate();
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users viewUser(int userId)
    /**
     * here we show the details of the user by the specific userId
     */
    {
        Users u = null;
        try {
            PreparedStatement ps = con.prepareStatement("Select * from User where userId=?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Users();
                u.setUserId(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setUserPassword(rs.getString(3));
                u.setUserPhone(rs.getInt(4));
                u.setUserEmail(rs.getString(5));
                u.setUserType(rs.getString(6));
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Users> viewAllUser()
    /**
     * Here we show List of Users
     */
    {
        Users u = null;
        List<Users> lists = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from User");
            while (rs.next()) {
                u = new Users();
                u.setUserId(rs.getInt(1));
                u.setUserName(rs.getString(2));
                u.setUserPassword(rs.getString(3));
                u.setUserPhone(rs.getInt(4));
                u.setUserEmail(rs.getString(5));
                u.setUserType(rs.getString(6));
                lists.add(u);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Users updateUser(Users u)
    /**
     * here we modify the details of user by the specific userId
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("update User set username=?, password=? ,userPhone=? , userEmail=? , userType= ? where userId=?");

            ps.setString(1, u.getUserName());
            ps.setString(2, u.getUserPassword());
            ps.setLong(3, u.getUserPhone());
            ps.setString(4, u.getUserEmail());
            ps.setString(5, u.getUserType());
            ps.setInt(6, u.getUserId());

            ps.executeQuery();
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void deleteUser(int userId)
    /**
     *Here we delete the User by the specific userId
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("delete from User where userid=?");
            ps.setInt(1, userId);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    public Users validate(int uid, String pass)
    /**
     * Here We validate the userId and Password
     */
    {
        Users u = null;
        try {
            PreparedStatement ps =
                    con.prepareStatement("select * from Users where UserId=? and Userpassword=?");
            ps.setInt(1, uid);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6));
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}