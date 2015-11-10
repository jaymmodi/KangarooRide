package com.ride.DAO;

import com.ride.DAO.Mappers.UserMapper;
import com.ride.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by jmmodi on 11/10/2015.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    public void create(User user) {
        String SQL = "insert into User (firstname, lastname,email,phone_number,address) values (?,?,?,?,?)";

        jdbcTemplateObject.update(SQL, user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getAddress());
        System.out.println("Created Record Name = " + user.getFirstName() + user.getLastName());
    }

    public User getUser(Integer id) {
        return null;
    }

    public List<User> listStudents() {
        String SQL = "select * from USER ";
        List<User> users = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return users;
    }

    public void delete(Integer id) {

    }

    public void update(Integer id, Integer age) {

    }
}
