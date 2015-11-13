package com.ride.DAO.Mappers;

import com.ride.Model.TimeSlot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jmmodi on 11/13/2015.
 */
public class TimeSlotMapper implements RowMapper<TimeSlot> {


    public TimeSlot mapRow(ResultSet resultSet, int i) throws SQLException {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setSlotNumber(resultSet.getInt("id"));
        return timeSlot;
    }
}
