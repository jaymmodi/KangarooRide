package com.ride.DAO.Mappers;

import com.ride.Model.Registration;
import com.ride.Model.Ride;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jmmodi on 11/14/2015.
 */
public class RegistrationMapper implements RowMapper<Registration> {

    @Override
    public Registration mapRow(ResultSet resultSet, int i) throws SQLException {
        Registration registration = new Registration();

        registration.setComments(resultSet.getString("comments"));
        registration.setRide_date(resultSet.getDate("ride_date"));
        registration.setRide_time(resultSet.getString("ride_time"));
        registration.setRide_time(resultSet.getString("ride_time"));
        registration.setUser_id(resultSet.getString("user_id"));

        Ride ride = new Ride();
        ride.setRideName(resultSet.getString("ride_name"));

        registration.setRide(ride);

        return registration;
    }
}
