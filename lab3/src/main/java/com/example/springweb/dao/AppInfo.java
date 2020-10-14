package com.example.springweb.dao;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import com.example.springweb.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class AppInfo implements Serializable {
    //
    private  String userName;

    //app 命名
    private String appName;

    //app 分类
    private String appRange;//适用范围
    private String businessAspect;//业务环节
    private String knowledgeType;//知识类型

    //app安全等级
    private String dangerAnalyse;//初步危险分析
    private String dangerSeverityRank;//危险严重性等级
    private String dangerPossibilityRank;//危险可能性等级
    private String systemRiskIndicator;//系统风险指标
    private String appControlType;//app控制类别
    private String appSecurityRank;//app安全等级确定


    //app测评
    private String appRangeTestRank;//适用范围测评等级
    private String effectRangeTestRank;//所解决工业问题的影响范围测评等级
    private String advancedLevelTestRank;//先进程度测评等级


    //获取
    public String GetUserName(){return userName;}
    public String GetAppName(){return appName;}
    public String GetAppRange(){ return appRange;}
    public String GetBusinessAspect(){ return businessAspect;}
    public String GetKnowledgeType(){return knowledgeType;}
    public String GetDangerAnalyse(){return dangerAnalyse;}
    public String GetDangerSeverityRank(){return dangerSeverityRank;}
    public String GetDangerPossibilityRank(){return dangerPossibilityRank;}
    public String GetSystemRiskIndicator(){return systemRiskIndicator;}
    public String GetAppControlType(){return appControlType;}
    public String GetAppSecurityRank(){return appSecurityRank;}
    public String GetAppRangeTestRank(){return appRangeTestRank;}
    public String GetEffectRangeTestRank(){return effectRangeTestRank;}
    public String GetAdvancedLevelTestRank(){return advancedLevelTestRank;}


    //设置
    public void SetUserName(String str){userName=str;}
    public void SetAppName(String str){appName=str;}
    public void SetAppRange(String str){appRange=str;}
    public void SetBusinessAspect(String str){businessAspect=str;}
    public void SetKnowledgeType(String str){knowledgeType=str;}
    public void SetDangerAnalyse(String str){dangerAnalyse=str;}
    public void SetDangerSeverityRank(String str){dangerSeverityRank=str;}
    public void SetDangerPossibilityRank(String str){dangerPossibilityRank=str;}
    public void SetSystemRiskIndicator(String str){systemRiskIndicator=str;}
    public void SetAppControlType(String str){appControlType=str;}
    public void SetAppSecurityRank(String str){appSecurityRank=str;}
    public void SetAppRangeTestRank(String str){appRangeTestRank=str;}
    public void SetEffectRangeTestRank(String str){effectRangeTestRank=str;}
    public void SetAdvancedLevelTestRank(String str){advancedLevelTestRank=str;}

    //输出完整app申请的信息
    public  void OutInfo(){
        System.out.println(
                        "(Info) userName:"+userName+" appName:"+appName+" appRange:"+appRange+" businessAspect:"+businessAspect+" knowledgeType:"+knowledgeType
                        +" dangerAnalyse:"+dangerAnalyse+""+" dangerSeverityRank:"+dangerSeverityRank
                        +" dangerPossibilityRank:"+dangerPossibilityRank
                        +" systemRiskIndicator:"+systemRiskIndicator+" appControlType:"+appControlType
                        +" appSecurityRank:"+appSecurityRank+" appRangeTestRank:"+appRangeTestRank
                        +" effectRangeTestRank:"+effectRangeTestRank+" advancedLevelTestRank:"+advancedLevelTestRank
        );

    }

    //检查有无表单参数是null，有则返回报错信息，无则返回null，正确的表单预期返回null
    public String CheckInfo(HttpServletRequest request){
        UserService us=new UserService();
        if(request.getParameter("appName").length()==0){
           return "请填写app命名";
        }

        if(request.getParameter("appName").length()>20){
            return "app命名长度不超过20位";
        }

        if(request.getParameter("appRange").length()==0){
            return "请填写适用范围";
        }

        if(request.getParameter("businessAspect").length()==0){
            return "请填写业务环节";
        }

        if(request.getParameter("knowledgeType").length()==0){
            return "请填写知识类型";
        }

        if(request.getParameter("dangerAnalyse").length()==0){
            return "请填写初步危险分析";
        }

        if(request.getParameter("dangerAnalyse").length()>70){
            return "初步危险分析字数不超过70个字";
        }

        if(request.getParameter("dangerSeverityRank").length()==0){
            return "请填写危险严重性等级";
        }

        if(request.getParameter("dangerPossibilityRank").length()==0){
            return "请填写危险可能性等级";
        }

        if(request.getParameter("systemRiskIndicator").length()==0){
            return "请填写系统风险指标";
        }
        if(request.getParameter("appControlType").length()==0){
            return "请填写app控制类别";
        }

        if(request.getParameter("appSecurityRank").length()==0){
            return "请填写app安全等级确定";
        }

        if(request.getParameter("appRangeTestRank").length()==0){
            return "请填写适用范围测评等级";
        }

        if(request.getParameter("effectRangeTestRank").length()==0){
            return "请填写所解决工业问题的影响范围测评等级";
        }
        if(request.getParameter("advancedLevelTestRank").length()==0){
            return "请填写先进程度测评等级";
        }

        return null;
    }

    //设置app的内容
    public void SetInfo(HttpServletRequest request){
        SetAppName(request.getParameter("appName"));
        SetAppRange(request.getParameter("appRange"));
        SetBusinessAspect(request.getParameter("businessAspect"));
        SetKnowledgeType(request.getParameter("knowledgeType"));
        SetDangerAnalyse(request.getParameter("dangerAnalyse"));
        SetDangerSeverityRank(request.getParameter("dangerSeverityRank"));
        SetDangerPossibilityRank(request.getParameter("dangerPossibilityRank"));
        SetSystemRiskIndicator(request.getParameter("systemRiskIndicator"));
        SetAppControlType(request.getParameter("appControlType"));
        SetAppSecurityRank(request.getParameter("appSecurityRank"));
        SetAppRangeTestRank(request.getParameter("appRangeTestRank"));
        SetEffectRangeTestRank(request.getParameter("effectRangeTestRank"));
        SetAdvancedLevelTestRank(request.getParameter("advancedLevelTestRank"));
        SetUserName(request.getSession().getAttribute("loginUname").toString());
    }


}
