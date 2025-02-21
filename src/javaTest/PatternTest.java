package javaTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {


        String input = "```json\n" +
                "[\n" +
                "  {\n" +
                "    \"记账日期\": \"2023-12-08\",\n" +
                "    \"摘要\": \"标准应付暂估入库\",\n" +
                "    \"借方科目\": \"库存商品\",\n" +
                "    \"借方科目ID\": \"1320970793907128325\",\n" +
                "    \"借方金额\": 30000,\n" +
                "    \"贷方科目\": \"暂估应付款\",\n" +
                "    \"贷方科目ID\": \"1320970800030813184\",\n" +
                "    \"贷方金额\": 30000,\n" +
                "    \"币别\": \"人民币\"\n" +
                "  }\n" +
                "]\n" +
                "```";

        String substring = input.substring(input.indexOf("["), input.lastIndexOf("]")+1);
        System.out.printf(substring);
//        matcher.group();


    }
}
