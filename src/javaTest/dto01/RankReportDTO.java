package javaTest.dto01;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;



public class RankReportDTO implements Serializable{

    //显示最高值
    public Boolean isShowMax;
    //显示最低值
    public Boolean isShowMin;
//    //显示自选公司均值
//    public Boolean isShowAvg;
    //显示本公司引入按钮
    public Boolean isShowImport;


    public List<CompanyInfo> companyInfos;

    public HashMap<String,String> companyItemName;
    public HashMap<String,String> indicatorsInfoName;

    public static class CompanyItem implements Serializable {
        public String itemId;
        public List<IndicatorsInfo> indicatorsInfo;
    }

    public static class IndicatorsInfo implements Serializable{
        //指标Id
        public String indicatorsId;
        //指标项值
        public String indicatorsValue;
        public boolean showImage;
    }

    public static class CompanyInfo implements Serializable{
        //公司项 常用：人数/占比/差距
        public List<CompanyItem> companyItem;
        //公司类型：0 普通公司；1 行业均值；2 行业中值；3 本公司
        public String type;
        //公司名称
        public String companyName;
        //公司id
        public String companyId;
    }
}
