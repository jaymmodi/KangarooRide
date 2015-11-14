package com.ride.DAO;

import com.ride.DAO.Mappers.StartEndSlotMapper;
import com.ride.DAO.Mappers.TimeSlotMapper;
import com.ride.Model.StartEndSlot;
import com.ride.Model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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

        String sql = "select count(*) from datetimeslot where ridedate = ?";
        Object[] inputs = new Object[]{dateStringToNewFormat};
        rows = jdbcTemplateObject.queryForObject(sql, inputs, Integer.class);

        return rows;
    }

    public StartEndSlot getStartSlot() {
        String sql = "select * from configuration";

        List<StartEndSlot> timeSlots = jdbcTemplateObject.query(sql, new StartEndSlotMapper());

        return timeSlots.get(0);
    }

    public void batchInsert(int slots, String date) {

        int slot[] = new int[slots];
        java.util.Date utilDate = null;

        try {
            utilDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < slot.length; i++) {
            slot[i] = i + 1;
        }

        String sql = "INSERT INTO datetimeslot\n" +
                "(id,ridedate,available)\n" +
                "VALUES\n" +
                "(?,?,?)";

        final java.util.Date finalUtilDate = utilDate;
        jdbcTemplateObject.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                int slotID = slot[i];
                preparedStatement.setInt(1, slotID);
                preparedStatement.setDate(2, new java.sql.Date(finalUtilDate.getTime()));
                preparedStatement.setBoolean(3, true);
            }

            @Override
            public int getBatchSize() {
                return slot.length;
            }
        });

    }

    public void update(Date utilDate) {
        String updateSql = "UPDATE datetimeslot SET available = ? WHERE ridedate = ?";
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Object[] params = {false, sqlDate};

        int[] types = {Types.BOOLEAN, Types.DATE};

        jdbcTemplateObject.update(updateSql, params, types);
    }
}
