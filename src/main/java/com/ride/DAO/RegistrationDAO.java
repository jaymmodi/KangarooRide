package com.ride.DAO;

import com.ride.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;

/**
 * Created by jmmodi on 11/14/2015.
 */
@Repository
public class RegistrationDAO {

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(Registration registration) {
        String SQL = "insert into Registration (user_id, ride_id,ride_date,ride_time,comments) values (?,?,?,?,?)";

        Date sqlDate = new Date(registration.getRide_date().getTime());

        jdbcTemplateObject.update(SQL, registration.getUser_id(), registration.getRide_id(), sqlDate, registration.getRide_time(), registration.getComments());
    }
}