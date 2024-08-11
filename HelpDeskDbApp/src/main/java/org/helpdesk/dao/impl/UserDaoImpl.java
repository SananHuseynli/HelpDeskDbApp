package org.helpdesk.dao.impl;

import org.helpdesk.bean.Role;
import org.helpdesk.bean.Users;
import org.helpdesk.dao.inter.AbstractDAO;
import org.helpdesk.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    private Users getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String email = rs.getString("email");
        String phone_number = rs.getString("phone_number");
        String gender = rs.getString("gender");
        Date dob = rs.getDate("dob");
        int role_id = rs.getInt("role_id");
        String role_name = rs.getString("role_name");
        Date date_created = rs.getDate("created_datetime");

        Role role = new Role(role_id, role_name);

        return new Users(id, name, surname, username, password, email, phone_number, gender, dob, role, date_created);
    }


    @Override
    public List<Users> getAllUser() {
        List<Users> result = new ArrayList<>();
        try (Connection c = connect();) {
            Statement st = c.createStatement();
            st.execute("select u.id,u.name,u.surname,u.username,u.password,u.email,u.phone_number,u.gender,u.dob,u.role_id,u.created_datetime,r.role_name from users u inner join role r on u.role_id=r.id");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String user_name = rs.getString("username");
//                String pass = rs.getString("password");
//                String email = rs.getString("email");
//                String phone_number = rs.getString("phone_number");
//                String gender = rs.getString("gender");
//                Date dob = rs.getDate("dob");
//                int role_id = rs.getInt("role_id");
//                String role_name=rs.getString("role_name");
//                Date dataCreation = rs.getDate("created_datetime");
//
//                Role role=new Role(role_id,role_name);
                Users u = getUser(rs);

                result.add(u);


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(Users u) {
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("update users set name=?,surname=?,username=?,email=?,phome_number=?,role_id=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getUsername());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPhoneNumber());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect();) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from users where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }
}
