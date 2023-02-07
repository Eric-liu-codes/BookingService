package com.solvd.bookingservice.mybatis;
import com.solvd.bookingservice.bookingservices.Organisation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrganisationBatis {
    @Insert("INSERT INTO ORGANIZATION(organizationID, name) "
            + "VALUES(#{organizationID}, #{name})")
    void insert(Organisation organization);

    @Select("SELECT * FROM ORGANIZATION WHERE organizationID = #{organizationID}")
    Organisation selectById(long organizationID);

    @Update("UPDATE ORGANIZATION SET name = #{name} WHERE organizationID = #{organizationID}")
    void update(Organisation organization);

    @Delete("DELETE FROM ORGANISATION WHERE organisationID = #{organisationID}")
    void delete(long organisationID);
}
