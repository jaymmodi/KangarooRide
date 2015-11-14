package com.ride.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by jmmodi on 11/14/2015.
 */
@Repository
public class RideDAO {

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public int getId(String rideName) {
        String query = "select id from ride where ride_name=?";
        Object[] inputs = new Object[]{rideName};

        int id = jdbcTemplateObject.queryForObject(query, inputs, Integer.class);

        return id;
    }
}
