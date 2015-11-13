package com.ride.DAO.Mappers;

import com.ride.Model.StartEndSlot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jmmodi on 11/13/2015.
 */
public class StartEndSlotMapper implements RowMapper<StartEndSlot> {


    @Override
    public StartEndSlot mapRow(ResultSet resultSet, int i) throws SQLException {
        StartEndSlot startEndSlot = new StartEndSlot();
        startEndSlot.setDuration(resultSet.getInt("duration"));

        startEndSlot.setStartHour(resultSet.getInt("hour_start"));
        startEndSlot.setStartMin(resultSet.getInt("min_start"));
        startEndSlot.setStartMeridian(resultSet.getString("meridian_start"));

        startEndSlot.setEndHour(resultSet.getInt("hour_end"));
        startEndSlot.setEndMin(resultSet.getInt("min_end"));
        startEndSlot.setEndMeridian(resultSet.getString("meridian_end"));

        return startEndSlot;
    }
}
