package com.solvd.bookingservice.mybatis;

import com.solvd.bookingservice.bookingservices.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountBatis {
    @Insert("INSERT INTO ACCOUNT(accountID, username, password, organisationID) "
            + "VALUES(#{accountID}, #{username}, #{password}, #{organisationID})")
    void insert(Account account);

    @Select("SELECT * FROM ACCOUNT WHERE accountID = #{accountID}")
    Account selectById(long accountID);

    @Update("UPDATE ACCOUNT SET username = #{username}, password = #{password}, "
            + "organisationID = #{organisationID} WHERE accountID = #{accountID}")
    void update(Account account);

    @Delete("DELETE FROM ACCOUNT WHERE accountID = #{accountID}")
    void delete(long accountID);
}
