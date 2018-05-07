package com.guomn.toolbox.mapper;

import com.guomn.toolbox.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SmsLogMapper {
    @Select("SELECT * FROM sms_log")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "toMobile", column = "to_mobile"),
            @Result(property = "logContant", column = "log_contant"),
            @Result(property = "sendStatus", column = "send_status")
    })
    List<SmsLog> getAll();

    @Select("SELECT * FROM sms_log WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "toMobile", column = "to_mobile"),
            @Result(property = "logContant", column = "log_contant"),
            @Result(property = "sendStatus", column = "send_status")
    })
    SmsLog getOne(Long id);

    @Insert("INSERT INTO sms_log(id,to_mobile,log_contant,send_status,create_time) VALUES(#{id}, #{toMobile}, #{logContant}, #{sendStatus}, NOW())")
    void insert(SmsLog logInput);

    @Update("UPDATE sms_log SET send_status = #{sendStatus} WHERE id =#{id}")
    void update(SmsLog logInput);

    @Delete("DELETE FROM sms_log WHERE id =#{id}")
    void delete(Long id);

}
