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


    public void insert(User user) {
        String SQL = "insert into User (user_id,firstname, lastname,email,phone_number) values (?,?,?,?,?)";

        jdbcTemplateObject.update(SQL, user.getEmailAddress(),user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber());
    }

    public int getUser(String email) {
        String sql = "select count(*) from USER where user_id = ?";
        Object[] inputs = new Object[]{email};
        Integer rows = jdbcTemplateObject.queryForObject(sql, inputs, Integer.class);
        return rows;
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
