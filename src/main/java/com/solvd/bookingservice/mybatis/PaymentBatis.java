package com.solvd.bookingservice.mybatis;
import com.solvd.bookingservice.bookingservices.Payment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PaymentBatis {
    @Insert("INSERT INTO PAYMENT(paymentID, type, amount, bookingID) "
            + "VALUES(#{paymentID}, #{type}, #{amount}, #{bookingID})")
    void insert(Payment payment);

    @Select("SELECT * FROM PAYMENT WHERE paymentID = #{paymentID}")
    Payment selectById(long paymentID);

    @Update("UPDATE PAYMENT SET type = #{type}, amount = #{amount}, bookingID = #{bookingID} "
            + "WHERE paymentID = #{paymentID}")
    void update(Payment payment);

    @Delete("DELETE FROM PAYMENT WHERE paymentID = #{paymentID}")
    void delete(long paymentID);
}
