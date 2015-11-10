package com.ride.DAO.Mappers;

import com.ride.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jmmodi on 11/10/2015.
 */
public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmailAddress(rs.getString("email_address"));

        return user;
    }
}
