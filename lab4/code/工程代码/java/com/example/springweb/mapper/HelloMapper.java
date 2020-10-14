package com.example.springweb.mapper;
import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface HelloMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "UserName"),
            @Result(property = "password", column = "Password"),
            @Result(property = "email", column = "Email"),
            @Result(property = "question", column = "KeyQuestion"),
            @Result(property = "answer", column = "KeyAnswer"),
            @Result(property = "isMaster", column = "UserType")
    })
    List<HelloUser> findAll();

    @Insert("insert into user(ID,UserName,Password,Email,KeyQuestion,KeyAnswer,UserType) values(#{id},#{name},#{password},#{email},#{question},#{answer},#{isMaster})")
    void insert(HelloUser helloUser);


    @Select("select * from user where ID = #{id}")
    @Results({
            @Result(property = "id",column = "ID"),
            @Result(property = "name",column = "UserName")
    })
    HelloUser getOne(String id);

    @Select("select * from user where UserName = #{name}")
    @Results({
            @Result(property = "id",column = "ID"),
            @Result(property = "name",column = "UserName"),
            @Result(property = "password", column = "Password"),
            @Result(property = "email", column = "Email"),
            @Result(property = "question", column = "KeyQuestion"),
            @Result(property = "answer", column = "KeyAnswer"),
            @Result(property = "isMaster", column = "UserType")
    })
    HelloUser getUser(String name);



    @Update("update user set UserName = #{name}, Password = #{password}, Email=#{email}, KeyQuestion=#{question},KeyAnswer=#{answer},UserType=#{isMaster}  where ID = #{id}")
    void updateByID(HelloUser helloUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from user where ID = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值
}
