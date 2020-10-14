package com.example.springweb;
import com.example.springweb.dao.AppInfo;
import com.example.springweb.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

import org.junit.runners.MethodSorters;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class AppInfoTest {
    @Autowired
    AppInfo appInfo;

    @Autowired
    HttpServletRequest request;

    @Test
    public void a_testUserName() {
        String str="123";
        appInfo.SetUserName(str);
        assertEquals(appInfo.GetUserName(),str);

        str="dsf";
        appInfo.SetUserName(str);
        assertEquals(appInfo.GetUserName(),str);
    }


    @Test
    public void b_testUserName() {
        String str="1235汉字6dfgssg3g";
        appInfo.SetUserName(str);
        assertEquals(appInfo.GetUserName(),str);

        str="dsasf..32r.fszvf";
        appInfo.SetUserName(str);
        assertEquals(appInfo.GetUserName(),str);
    }


    @Test
    public void c_testAppName() {
        String str="123";
        appInfo.SetAppName(str);
        assertEquals(appInfo.GetAppName(),str);

        str="一二三";
        appInfo.SetAppName(str);
        assertEquals(appInfo.GetAppName(),str);
    }


    @Test
    public void d_testAppName() {
        String str="saflh汉字h342//.fw.";
        appInfo.SetAppName(str);
        assertEquals(appInfo.GetAppName(),str);

        str="asfv23/f..sfasd2";
        appInfo.SetAppName(str);
        assertEquals(appInfo.GetAppName(),str);
    }

    @Test
    public void e_testAppRange() {
        String str="saflhh342//.fw.";
        appInfo.SetAppRange(str);
        assertEquals(appInfo.GetAppRange(),str);

        str="asfv23/f..sfasd2";
        appInfo.SetAppRange(str);
        assertEquals(appInfo.GetAppRange(),str);
    }

    @Test
    public void f_testAppRange() {
        String str="safl";
        appInfo.SetAppRange(str);
        assertEquals(appInfo.GetAppRange(),str);

        str="12342352";
        appInfo.SetAppRange(str);
        assertEquals(appInfo.GetAppRange(),str);
    }

    @Test
    public void g_testBusinessAspect() {
        String str="safl";
        appInfo.SetBusinessAspect(str);
        assertEquals(appInfo.GetBusinessAspect(),str);

        str="12342352";
        appInfo.SetBusinessAspect(str);
        assertEquals(appInfo.GetBusinessAspect(),str);
    }

    @Test
    public void h_testBusinessAspect() {
        String str="saf32/5/.135=DDdsal";
        appInfo.SetBusinessAspect(str);
        assertEquals(appInfo.GetBusinessAspect(),str);

        str="1234223rSDA测试Ffesadf32f.--352";
        appInfo.SetBusinessAspect(str);
        assertEquals(appInfo.GetBusinessAspect(),str);
    }

    @Test
    public void i_testKnowledgeType() {
        String str="saf32/5/.135=DDdsal";
        appInfo.SetKnowledgeType(str);
        assertEquals(appInfo.GetKnowledgeType(),str);

        str="1234223rSDA测试Ffesadf32f.--352";
        appInfo.SetKnowledgeType(str);
        assertEquals(appInfo.GetKnowledgeType(),str);
    }

    @Test
    public void j_testKnowledgeType() {
        String str="hjgj";
        appInfo.SetKnowledgeType(str);
        assertEquals(appInfo.GetKnowledgeType(),str);

        str="1234352";
        appInfo.SetKnowledgeType(str);
        assertEquals(appInfo.GetKnowledgeType(),str);
    }



    @Test
    public void k_testDangerAnalyse() {
        String str="hjgj";
        appInfo.SetDangerAnalyse(str);
        assertEquals(appInfo.GetDangerAnalyse(),str);

        str="1234352";
        appInfo.SetDangerAnalyse(str);
        assertEquals(appInfo.GetDangerAnalyse(),str);
    }

    @Test
    public void l_testDangerAnalyse() {
        String str="hjasf.a.sf.f.s.23f.=s=f-gj";
        appInfo.SetDangerAnalyse(str);
        assertEquals(appInfo.GetDangerAnalyse(),str);

        str="12ha字阿斯克吗测一测2";
        appInfo.SetDangerAnalyse(str);
        assertEquals(appInfo.GetDangerAnalyse(),str);
    }


    @Test
    public void m_testDangerSeverityRank() {
        String str="hjasf.a.sf.f.s.23f.=s=f-gj";
        appInfo.SetDangerSeverityRank(str);
        assertEquals(appInfo.GetDangerSeverityRank(),str);

        str="12ha字阿斯克吗测一测2";
        appInfo.SetDangerSeverityRank(str);
        assertEquals(appInfo.GetDangerSeverityRank(),str);
    }

    @Test
    public void n_testDangerSeverityRank() {
        String str="3253246q325";
        appInfo.SetDangerSeverityRank(str);
        assertEquals(appInfo.GetDangerSeverityRank(),str);

        str="1sdfadg2gergg2";
        appInfo.SetDangerSeverityRank(str);
        assertEquals(appInfo.GetDangerSeverityRank(),str);
    }


    @Test
    public void o_testDangerPossibilityRank() {
        String str="3253246q325";
        appInfo.SetDangerPossibilityRank(str);
        assertEquals(appInfo.GetDangerPossibilityRank(),str);

        str="1sdfadg2gergg2";
        appInfo.SetDangerPossibilityRank(str);
        assertEquals(appInfo.GetDangerPossibilityRank(),str);
    }

    @Test
    public void p_testDangerPossibilityRank() {
        String str="3253246写代码真累啊，猪脚真帅啊，我分高一点噢25";
        appInfo.SetDangerPossibilityRank(str);
        assertEquals(appInfo.GetDangerPossibilityRank(),str);

        str="1sdfad测试-asd--fas//ad1";
        appInfo.SetDangerPossibilityRank(str);
        assertEquals(appInfo.GetDangerPossibilityRank(),str);
    }

    @Test
    public void q_testSystemRiskIndicator() {
        String str="3253246写代码真累啊，猪脚真帅啊，我分高一点噢25";
        appInfo.SetSystemRiskIndicator(str);
        assertEquals(appInfo.GetSystemRiskIndicator(),str);

        str="1sdfad测试-asd--fas//ad1";
        appInfo.SetSystemRiskIndicator(str);
        assertEquals(appInfo.GetSystemRiskIndicator(),str);
    }

    @Test
    public void r_testSystemRiskIndicator() {
        String str="325325";
        appInfo.SetSystemRiskIndicator(str);
        assertEquals(appInfo.GetSystemRiskIndicator(),str);

        str="asfsaf3fsfsfsdfsdfffsdg";
        appInfo.SetSystemRiskIndicator(str);
        assertEquals(appInfo.GetSystemRiskIndicator(),str);
    }


    @Test
    public void s_testAppControlType() {
        String str="325325";
        appInfo.SetAppControlType(str);
        assertEquals(appInfo.GetAppControlType(),str);

        str="asfsaf3fsfsfsdfsdfffsdg";
        appInfo.SetAppControlType(str);
        assertEquals(appInfo.GetAppControlType(),str);
    }

    @Test
    public void t_testAppControlType() {
        String str="325代码快写完了加油啊325";
        appInfo.SetAppControlType(str);
        assertEquals(appInfo.GetAppControlType(),str);

        str="asfsaf3asd///=;234/.fs.fsfsfsdfsdfffsdg";
        appInfo.SetAppControlType(str);
        assertEquals(appInfo.GetAppControlType(),str);
    }

    @Test
    public void u_testAppSecurityRank() {
        String str="325代码快写完了加油啊325";
        appInfo.SetAppSecurityRank(str);
        assertEquals(appInfo.GetAppSecurityRank(),str);

        str="asfsaf3asd///=;234/.fs.fsfsfsdfsdfffsdg";
        appInfo.SetAppSecurityRank(str);
        assertEquals(appInfo.GetAppSecurityRank(),str);
    }

    @Test
    public void v_testAppSecurityRank() {
        String str="3253254326325";
        appInfo.SetAppSecurityRank(str);
        assertEquals(appInfo.GetAppSecurityRank(),str);

        str="grhinhdsigfsdgihkjaghsdg";
        appInfo.SetAppSecurityRank(str);
        assertEquals(appInfo.GetAppSecurityRank(),str);
    }

    @Test
    public void w_testAppRangeTestRank() {
        String str="3253254326325";
        appInfo.SetAppRangeTestRank(str);
        assertEquals(appInfo.GetAppRangeTestRank(),str);

        str="grhinhdsigfsdgihkjaghsdg";
        appInfo.SetAppRangeTestRank(str);
        assertEquals(appInfo.GetAppRangeTestRank(),str);
    }

    @Test
    public void x_testAppRangeTestRank() {
        String str="3253宿舍我国后i万和宫和我刚问过后i是德国54326325";
        appInfo.SetAppRangeTestRank(str);
        assertEquals(appInfo.GetAppRangeTestRank(),str);

        str="grhinhdsigfsdg=sd-saf//。/、、34*FAAFDSFihkjaghsdg";
        appInfo.SetAppRangeTestRank(str);
        assertEquals(appInfo.GetAppRangeTestRank(),str);
    }

    @Test
    public void y_testEffectRangeTestRank() {
        String str="3253宿舍我国后i万和宫和我刚问过后i是德国54326325";
        appInfo.SetEffectRangeTestRank(str);
        assertEquals(appInfo.GetEffectRangeTestRank(),str);

        str="grhinhdsigfsdg=sd-saf//。/、、34*FAAFDSFihkjaghsdg";
        appInfo.SetEffectRangeTestRank(str);
        assertEquals(appInfo.GetEffectRangeTestRank(),str);
    }

    @Test
    public void z_testEffectRangeTestRank() {
        String str="33223534536325";
        appInfo.SetEffectRangeTestRank(str);
        assertEquals(appInfo.GetEffectRangeTestRank(),str);

        str="grhinhdskjaghsdg";
        appInfo.SetEffectRangeTestRank(str);
        assertEquals(appInfo.GetEffectRangeTestRank(),str);
    }

    @Test
    public void za_testAdvancedLevelTestRank() {
        String str="33223534536325";
        appInfo.SetAdvancedLevelTestRank(str);
        assertEquals(appInfo.GetAdvancedLevelTestRank(),str);

        str="grhinhdskjaghsdg";
        appInfo.SetAdvancedLevelTestRank(str);
        assertEquals(appInfo.GetAdvancedLevelTestRank(),str);
    }


    @Test
    public void zb_testAdvancedLevelTestRank() {
        String str="3322的说法是顾客文化3534536325";
        appInfo.SetAdvancedLevelTestRank(str);
        assertEquals(appInfo.GetAdvancedLevelTestRank(),str);

        str="grhinhdsk=dsf=SDF=dsf==SF==sdf/SF./jaghsdg";
        appInfo.SetAdvancedLevelTestRank(str);
        assertEquals(appInfo.GetAdvancedLevelTestRank(),str);
    }

}
