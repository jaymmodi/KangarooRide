package com.ride.DAO;

import com.ride.DAO.Mappers.StartEndSlotMapper;
import com.ride.DAO.Mappers.TimeSlotMapper;
import com.ride.Model.StartEndSlot;
import com.ride.Model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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


    public List<TimeSlot> getSlotsFor(String dateStringToNewFormat) {
        dateStringToNewFormat = dateStringToNewFormat.replace("/", "-");

        String sql = "select * from datetimeslot where ridedate =" + "\'" + dateStringToNewFormat + "\'" + "and available = TRUE";

        List<TimeSlot> timeSlots = jdbcTemplateObject.query(sql, new TimeSlotMapper());

        return timeSlots;
    }

    public int getRowCountForThisDate(String dateStringToNewFormat) {
        dateStringToNewFormat = dateStringToNewFormat.replace("/", "-");
        int rows = 0;

        String sql = "select count(*) from datetimeslot where ridedate =" + " \' " + dateStringToNewFormat + "\'";
        try {
            Statement st = jdbcTemplateObject.getDataSource().getConnection().createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            resultSet.next();
            rows = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public StartEndSlot getStartSlot() {
        String sql = "select * from configuration";

        List<StartEndSlot> timeSlots = jdbcTemplateObject.query(sql, new StartEndSlotMapper());

        return timeSlots.get(0);
    }
}
