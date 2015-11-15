package com.ride.DAO;

import com.ride.DAO.Mappers.RegistrationMapper;
import com.ride.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Date;
import java.util.List;

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

    public List<Registration> getAllRegistrations() {
        String sql = "select user_id,ride_date,ride_time,comments,ride_name " +
                "from registration " +
                "inner join ride " +
                "where registration.ride_id = ride.id ";

        List<Registration> registrations = jdbcTemplateObject.query(sql, new RegistrationMapper());

        return registrations;


    }

    public void deleteRegistration(String user_id, Date utilDate, String ride_time) {
        String updateSql = "DELETE from registration WHERE user_id = ? and ride_date =? and ride_time=?";

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        Object[] params = {user_id, sqlDate, ride_time};

        int[] types = {Types.VARCHAR, Types.DATE, Types.VARCHAR};

        jdbcTemplateObject.update(updateSql, params, types);
    }
}
