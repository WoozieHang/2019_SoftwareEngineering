package com.example.springweb.mapper;

import com.example.springweb.dao.AppInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppInfoMapper {
    @Select("select * from appinfo")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "appName", column = "appName"),
            @Result(property = "appRange", column = "appRange"),
            @Result(property = "businessAspect", column = "businessAspect"),
            @Result(property = "knowledgeType", column = "knowledgeType"),
            @Result(property = "dangerAnalyse", column = "dangerAnalyse"),
            @Result(property = "dangerSeverityRank", column = "dangerSeverityRank"),
            @Result(property = "dangerPossibilityRank", column = "dangerPossibilityRank"),
            @Result(property = "systemRiskIndicator", column = "systemRiskIndicator"),
            @Result(property = "appControlType", column = "appControlType"),
            @Result(property = "appSecurityRank", column = "appSecurityRank"),
            @Result(property = "appRangeTestRank", column = "appRangeTestRank"),
            @Result(property = "effectRangeTestRank", column = "effectRangeTestRank"),
            @Result(property = "advancedLevelTestRank", column = "advancedLevelTestRank")
    })
    List<AppInfo> findAll();

    @Insert("insert into appinfo(userName,appName,appRange,businessAspect,knowledgeType,dangerAnalyse,dangerSeverityRank,dangerPossibilityRank,systemRiskIndicator,appControlType,appSecurityRank,appRangeTestRank,effectRangeTestRank,advancedLevelTestRank) values(#{userName},#{appName},#{appRange},#{businessAspect},#{knowledgeType},#{dangerAnalyse},#{dangerSeverityRank},#{dangerPossibilityRank},#{systemRiskIndicator},#{appControlType},#{appSecurityRank},#{appRangeTestRank},#{effectRangeTestRank},#{advancedLevelTestRank})")
    void insert(AppInfo appInfo);


    @Select("select * from appinfo where appName = #{appName}")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "appName", column = "appName"),
            @Result(property = "appRange", column = "appRange"),
            @Result(property = "businessAspect", column = "businessAspect"),
            @Result(property = "knowledgeType", column = "knowledgeType"),
            @Result(property = "dangerAnalyse", column = "dangerAnalyse"),
            @Result(property = "dangerSeverityRank", column = "dangerSeverityRank"),
            @Result(property = "dangerPossibilityRank", column = "dangerPossibilityRank"),
            @Result(property = "systemRiskIndicator", column = "systemRiskIndicator"),
            @Result(property = "appControlType", column = "appControlType"),
            @Result(property = "appSecurityRank", column = "appSecurityRank"),
            @Result(property = "appRangeTestRank", column = "appRangeTestRank"),
            @Result(property = "effectRangeTestRank", column = "effectRangeTestRank"),
            @Result(property = "advancedLevelTestRank", column = "advancedLevelTestRank")
    })
    AppInfo getAppInfo(String appName);



    @Update("update appinfo set userName = #{userName},appName = #{appName},appRange = #{appRange},businessAspect = #{businessAspect},knowledgeType = #{knowledgeType},dangerAnalyse = #{dangerAnalyse},dangerSeverityRank = #{dangerSeverityRank},dangerPossibilityRank = #{dangerPossibilityRank},systemRiskIndicator = #{systemRiskIndicator},appControlType = #{appControlType},appSecurityRank = #{appSecurityRank},appRangeTestRank = #{appRangeTestRank},effectRangeTestRank = #{effectRangeTestRank},advancedLevelTestRank = #{advancedLevelTestRank} where appName = #{appName}")
    void updateByID(AppInfo appInfo);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from appinfo where appName = #{appName}")
    void deleteByID(String appName);//DELETE FROM 表名称 WHERE 列名称 = 值
}
