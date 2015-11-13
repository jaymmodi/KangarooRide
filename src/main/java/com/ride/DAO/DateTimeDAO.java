package com.ride.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by jmmodi on 11/13/2015.
 */

@Repository
public class DateTimeDAO {

    private JdbcTemplate jdbcTemplateObject;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public ArrayList<String> getSlotsFor(String dateStringToNewFormat) {

        Date date = Date.valueOf(dateStringToNewFormat.replace("/", "-"));

        String sql = "select count(*) from datetimeslot where ridedate =" + date;

        try {
            Statement st = jdbcTemplateObject.getDataSource().getConnection().createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.next();
            if (resultSet.getInt(1) == 0) {
                //insert those 18 slots into dateTimeSlot;
                // return back those all 18 slots.
            } else {
                //find slots which are available for that date.
                //findSlots
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
