package com.solvd.bookingservice.mybatis;
import com.solvd.bookingservice.bookingservices.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface RoomBatis {
    @Insert("INSERT INTO ROOM(roomID, roomNum, type, bookingID) "
            + "VALUES(#{roomID}, #{roomNum}, #{type}, #{bookingID})")
    void insert(Room room);

    @Select("SELECT * FROM ROOM WHERE roomID = #{roomID}")
    Room selectById(long roomID);

    @Update("UPDATE ROOM SET roomNum = #{roomNum}, type = #{type}, bookingID = #{bookingID} WHERE roomID = #{roomID}")
    void update(Room room);

    @Delete("DELETE FROM ROOM WHERE roomID = #{roomID}")
    void delete(long roomID);
}
