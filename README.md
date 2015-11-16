# KangarooRide
A web application using SpringMVC 4 and Thymeleaf where a user would be able to register for a ride.


Technologies Used : 
1. Thymeleaf
2. Bootstrap
3. Spring MVC
4. Spring JDBCTemplate
5. MySQL


My application is running on Tomcat Server (Tomcat 8).

You would probably need following tables to run this project properly.

create table registration(
    id INT(6) auto_increment Primary Key,
    user_id varchar(100),
    ride_id int(6),
    ride_date date,
    ride_time varchar(100),
    comments varchar(100)
);


create table ride(
    id INT(6) auto_increment Primary Key,
    ride_name varchar(100)
);


create table user(
    user_id varchar(100) Primary Key,
    firstname varchar(100),
    lastname varchar(100),
    email varchar(100),
    phone_number varchar(100),
);


create table configuration(
    hour_start int(6),
    min_start int(6),
    meridian_start varchar(6),
    hour_end int(6),
    min_end int(6),
    meridian_end varchar(6)
);

create table datetimeslot(
    id int(6),
    ridedate date,
    available boolean
);
