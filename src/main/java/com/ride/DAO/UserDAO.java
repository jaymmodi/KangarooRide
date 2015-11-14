package com.ride.DAO;

import com.ride.Model.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by jmmodi on 11/10/2015.
 */
public interface UserDAO {


    void setDataSource(DataSource ds);

    void insert(User user);

    int getUser(String email);

    List<User> listStudents();

    void delete(Integer id);

    void update(Integer id, Integer age);

}
