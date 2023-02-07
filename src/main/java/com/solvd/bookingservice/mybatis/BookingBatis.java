package com.solvd.bookingservice.mybatis;
import com.solvd.bookingservice.bookingservices.Booking;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookingBatis {
    @Insert("INSERT INTO BOOKING(bookingID, date, accountID) "
            + "VALUES(#{bookingID}, #{date}, #{accountID})")
    void insert(Booking booking);

    @Select("SELECT * FROM BOOKING WHERE bookingID = #{bookingID}")
    Booking selectById(long bookingID);

    @Update("UPDATE BOOKING SET date = #{date}, accountID = #{accountID} WHERE bookingID = #{bookingID}")
    void update(Booking booking);

    @Delete("DELETE FROM BOOKING WHERE bookingID = #{bookingID}")
    void delete(long bookingID);
}
