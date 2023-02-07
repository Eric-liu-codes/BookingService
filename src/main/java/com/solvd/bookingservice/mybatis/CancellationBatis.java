package com.solvd.bookingservice.mybatis;
import com.solvd.bookingservice.bookingservices.Cancellation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CancellationBatis {
    @Insert("INSERT INTO CANCELLATION(cancellationID, type, reason, bookingID) "
            + "VALUES(#{cancellationID}, #{type}, #{reason}, #{bookingID})")
    void insert(Cancellation cancellation);

    @Select("SELECT * FROM CANCELLATION WHERE cancellationID = #{cancellationID}")
    Cancellation selectById(long cancellationID);

    @Update("UPDATE CANCELLATION SET type = #{type}, reason = #{reason}, bookingID = #{bookingID} "
            + "WHERE cancellationID = #{cancellationID}")
    void update(Cancellation cancellation);

    @Delete("DELETE FROM CANCELLATION WHERE cancellationID = #{cancellationID}")
    void delete(long cancellationID);
}
