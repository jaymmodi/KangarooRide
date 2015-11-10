package com.ride.DAO;

import com.ride.Model.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by jmmodi on 11/10/2015.
 */
public interface UserDAO {


    void setDataSource(DataSource ds);

    void create(User user);

    User getUser(Integer id);

    List<User> listStudents();

    void delete(Integer id);

    void update(Integer id, Integer age);

}
