package javaTest;

public class PatternTest2 {
    public static void main(String[] args) {


        String input = "```json[  {    \"记账日期\": \"2023-12-08\",    \"摘要\": \"标准应付暂估入库\",    \"借方科目\": \"库存商品\",    \"借方科目ID\": \"1320970793907128325\",    \"借方金额\": 30000,    \"贷方科目\": \"暂估应付款\",    \"贷方科目ID\": \"1320970800030813184\",    \"贷方金额\": 30000,    \"币别\": \"人民币\"  }]```";

        String jsonInput = input.substring(input.indexOf("["), input.lastIndexOf("]")+1);
        System.out.printf(jsonInput);
//        matcher.group();


    }
}


