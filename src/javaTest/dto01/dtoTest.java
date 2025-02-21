package javaTest.dto01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class dtoTest {
    public static void main(String[] args) {
        RankReportDTO dto = new RankReportDTO();
        dto.isShowImport = true;
        dto.isShowMax = true;
        dto.isShowMin = false;

        HashMap<String, String> companyItemName = new HashMap<>();
        companyItemName.put("renshu", "人数");
        companyItemName.put("zhuanbi", "占比");
        companyItemName.put("chaju", "差距");
        dto.companyItemName = companyItemName;

        HashMap<String, String> indicatorsInfoName = new HashMap<>();
        indicatorsInfoName.put("yuangong", "员工总数");
        indicatorsInfoName.put("xiaoshou", "销售人员");
        dto.indicatorsInfoName = indicatorsInfoName;

        RankReportDTO.CompanyInfo companyInfo0 = new RankReportDTO.CompanyInfo();
        companyInfo0.companyId = "001";
        companyInfo0.companyName = "本公司";
        companyInfo0.type = "3";

        RankReportDTO.CompanyInfo companyInfo1 = new RankReportDTO.CompanyInfo();
        companyInfo1.companyId = "002311";
        companyInfo1.companyName = "铜梁科技";
        companyInfo1.type = "0";

        RankReportDTO.CompanyItem companyItem0 = new RankReportDTO.CompanyItem();
        RankReportDTO.CompanyItem companyItem1 = new RankReportDTO.CompanyItem();
        RankReportDTO.CompanyItem companyItem2 = new RankReportDTO.CompanyItem();

        companyItem0.itemId = "renshu";
        companyItem1.itemId = "zhuanbi";
        companyItem2.itemId = "chaju";

        RankReportDTO.IndicatorsInfo indicatorsInfo0 = new RankReportDTO.IndicatorsInfo();
        RankReportDTO.IndicatorsInfo indicatorsInfo1 = new RankReportDTO.IndicatorsInfo();
        RankReportDTO.IndicatorsInfo indicatorsInfo2 = new RankReportDTO.IndicatorsInfo();

        indicatorsInfo0.indicatorsId = "yuangong";
        indicatorsInfo1.indicatorsId = "yuangong";
        indicatorsInfo2.indicatorsId = "yuangong";

        indicatorsInfo0.showImage = true;

        indicatorsInfo0.indicatorsValue = "100%%";
        indicatorsInfo1.indicatorsValue = "54527";
        indicatorsInfo2.indicatorsValue = "54527";

        RankReportDTO.IndicatorsInfo indicatorsInfo0a = new RankReportDTO.IndicatorsInfo();
        RankReportDTO.IndicatorsInfo indicatorsInfo1a = new RankReportDTO.IndicatorsInfo();
        RankReportDTO.IndicatorsInfo indicatorsInfo2a = new RankReportDTO.IndicatorsInfo();

        indicatorsInfo0a.indicatorsId = "xiaoshou";
        indicatorsInfo1a.indicatorsId = "xiaoshou";
        indicatorsInfo2a.indicatorsId = "xiaoshou";

        indicatorsInfo0a.indicatorsValue = "70%%";
        indicatorsInfo1a.indicatorsValue = null;
        indicatorsInfo2a.indicatorsValue = "33333";

        List<RankReportDTO.CompanyItem> companyItems = Arrays.asList(companyItem0, companyItem1);
        List<RankReportDTO.CompanyItem> companyItems1 = Arrays.asList(companyItem0, companyItem1, companyItem2);

        companyInfo0.companyItem = companyItems;
        companyInfo1.companyItem = companyItems1;

        companyItem0.indicatorsInfo = Arrays.asList(indicatorsInfo0, indicatorsInfo0a);
        companyItem1.indicatorsInfo = Arrays.asList(indicatorsInfo1, indicatorsInfo1a);
        companyItem2.indicatorsInfo = Arrays.asList(indicatorsInfo2, indicatorsInfo2a);

        dto.companyInfos = Arrays.asList(companyInfo0, companyInfo1);

        String s = JSON.toJSONString(dto, SerializerFeature.DisableCircularReferenceDetect
                ,SerializerFeature.WriteMapNullValue);
        System.out.printf(s);
//        System.out.printf(JSON.toJSONString(companyInfo0));
//        System.out.printf(JSON.toJSONString(companyInfo1));

    }
}
