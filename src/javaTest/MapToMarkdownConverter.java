package javaTest;

import java.math.BigDecimal;
import java.math.RoundingMode; // 虽然这里不直接用 rounding，但BigDecimal操作有时会涉及
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

// 假设的 FiQuotaValue 类 (保持不变)
class FiQuotaValue {
    private BigDecimal value;

    public FiQuotaValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FiQuotaValue{" + "value=" + value + '}';
    }
}

public class MapToMarkdownConverter {

    // --- 配置 ---
    // 用于格式化整数部分的千位分隔符
    private static final DecimalFormat INTEGER_PART_FORMATTER = new DecimalFormat("#,##0");
    // 缺失数据时显示的占位符
    private static final String MISSING_VALUE_PLACEHOLDER = ""; // 或者使用 "-"

    /**
     * 格式化 BigDecimal: 去除尾随零，保留精度，添加千位分隔符
     */
    private static String formatBigDecimalStripZerosWithSeparators(BigDecimal value) {
        if (value == null) {
            return MISSING_VALUE_PLACEHOLDER;
        }
        // 1. 去除尾随零
        BigDecimal strippedValue = value.stripTrailingZeros();

        // 2. 转换为普通字符串表示
        String plainString = strippedValue.toPlainString();

        // 3. 分离整数和小数部分，并为整数部分添加分隔符
        String integerPart;
        String fractionalPart = "";
        int decimalPointIndex = plainString.indexOf('.');

        if (decimalPointIndex != -1) {
            integerPart = plainString.substring(0, decimalPointIndex);
            fractionalPart = plainString.substring(decimalPointIndex); // 包括小数点 "."
        } else {
            integerPart = plainString;
        }

        // 格式化整数部分 (需要先转回数字类型，或者手动插入)
        // 为了安全和简单，我们格式化原始的 strippedValue (如果是整数的话)，或者只格式化提取的整数部分字符串对应的数值
        String formattedIntegerPart;
        try {
            // 如果 strippedValue 本身就是整数 (scale <= 0)
            if (strippedValue.scale() <= 0) {
                formattedIntegerPart = INTEGER_PART_FORMATTER.format(strippedValue);
            } else {
                // 否则，只格式化整数部分
                // 注意：如果整数部分非常大，直接 new BigDecimal(integerPart) 可能有风险，但通常还好
                formattedIntegerPart = INTEGER_PART_FORMATTER.format(new BigDecimal(integerPart));
                //更安全的方式是处理integerPart字符串手动插入逗号，但DecimalFormat通常够用
            }
        } catch (NumberFormatException | ArithmeticException e) {
            // 格式化失败，回退到原始整数部分
            System.err.println("Warning: Could not format integer part '" + integerPart + "'. Error: " + e.getMessage());
            formattedIntegerPart = integerPart;
        }


        // 4. 重新组合
        return formattedIntegerPart + fractionalPart;
    }


    /**
     * 将嵌套的 Map 转换为 Markdown 表格 (使用新的格式化逻辑)
     *
     * @param dataMap           数据 Map (k: 期间编码 ; v: [k: 指标编码 ; v: [ k-公司编码 v-指标值]])
     * @param stockCodeAndName  公司代码到名称的映射
     * @param indicatorCodeAndName 指标代码到名称的映射
     * @return Markdown 格式的字符串
     */
    public static String convertMapToMarkdown(
            Map<String, Map<String, Map<String, FiQuotaValue>>> dataMap,
            Map<String, String> stockCodeAndName,
            Map<String, String> indicatorCodeAndName) {

        if (dataMap == null || dataMap.isEmpty() || stockCodeAndName == null || stockCodeAndName.isEmpty() || indicatorCodeAndName == null || indicatorCodeAndName.isEmpty()) {
            return "| 指标 | \n| ---- |"; // 返回一个空的有效 Markdown 表格
        }

        // --- 维度收集与排序 (与之前相同) ---
        List<String> sortedPeriods = dataMap.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<String> sortedCompanyCodes = stockCodeAndName.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        Set<String> indicatorCodes = dataMap.values().stream()
                .flatMap(indicatorMap -> indicatorMap.keySet().stream())
                .collect(Collectors.toSet());
        List<String> sortedIndicatorCodes = indicatorCodes.stream()
                .filter(indicatorCodeAndName::containsKey)
                .sorted()
                .collect(Collectors.toList());

        int periodCount = sortedPeriods.size();
        int companyCount = sortedCompanyCodes.size();
        int totalColumns = 1 + companyCount * periodCount;

        StringBuilder markdownBuilder = new StringBuilder();

        // --- 表头构建 (与之前相同) ---
        // 表头1 (公司)
        markdownBuilder.append("| 指标 ");
        for (String companyCode : sortedCompanyCodes) {
            String companyName = stockCodeAndName.getOrDefault(companyCode, companyCode);
            markdownBuilder.append("| ").append(companyName);
            for (int i = 1; i < periodCount; i++) markdownBuilder.append(" |");
            markdownBuilder.append(" ");
        }
        markdownBuilder.append("|\n");
        // 表头2 (分隔符)
        markdownBuilder.append("|");
        for (int i = 0; i < totalColumns; i++) markdownBuilder.append(" ---- |");
        markdownBuilder.append("\n");
        // 表头3 (期间)
        markdownBuilder.append("| ");
        for (String companyCode : sortedCompanyCodes) {
            for (String period : sortedPeriods) markdownBuilder.append("| ").append(period).append(" ");
        }
        markdownBuilder.append("|\n");

        // --- 数据行构建 (使用新的格式化方法) ---
        for (String indicatorCode : sortedIndicatorCodes) {
            String indicatorName = indicatorCodeAndName.getOrDefault(indicatorCode, indicatorCode);
            markdownBuilder.append("| ").append(indicatorName).append(" ");

            for (String companyCode : sortedCompanyCodes) {
                for (String period : sortedPeriods) {
                    // 安全地获取数据
                    FiQuotaValue quotaValue = Optional.ofNullable(dataMap.get(period))
                            .map(indicatorMap -> indicatorMap.get(indicatorCode))
                            .map(companyMap -> companyMap.get(companyCode))
                            .orElse(null);

                    // 使用新的格式化方法
                    String formattedValue = formatBigDecimalStripZerosWithSeparators(
                            quotaValue != null ? quotaValue.getValue() : null
                    );

                    markdownBuilder.append("| ").append(formattedValue).append(" ");
                }
            }
            markdownBuilder.append("|\n");
        }

        return markdownBuilder.toString();
    }

    // --- 主方法 (示例用法) ---
    public static void main(String[] args) {
        // 示例数据
        HashMap<String, Map<String, Map<String, FiQuotaValue>>> map = new HashMap<>();
        Map<String, String> stockCodeAndName = new LinkedHashMap<>();
        Map<String, String> indicatorCodeAndName = new HashMap<>();

        stockCodeAndName.put("YONYOU", "用友");
        stockCodeAndName.put("KINGDEE", "金蝶");

        indicatorCodeAndName.put("EMP_TOTAL", "员工总数（人）");
        indicatorCodeAndName.put("REV_PER_EMP", "人均创收(万/人)");
        indicatorCodeAndName.put("NET_PROFIT", "净利润(万元)"); // 添加一个新指标用于测试

        // --- 填充数据 ---
        // 2024
        Map<String, Map<String, FiQuotaValue>> period2024 = new HashMap<>();
        Map<String, FiQuotaValue> empTotal2024 = new HashMap<>();
        empTotal2024.put("YONYOU", new FiQuotaValue(new BigDecimal("21283"))); // 整数
        empTotal2024.put("KINGDEE", new FiQuotaValue(new BigDecimal("12149")));
        Map<String, FiQuotaValue> revPerEmp2024 = new HashMap<>();
        revPerEmp2024.put("YONYOU", new FiQuotaValue(new BigDecimal("0.00000999999"))); // 带尾随0的小数
        revPerEmp2024.put("KINGDEE", new FiQuotaValue(new BigDecimal("51.5"))); // 普通小数
        Map<String, FiQuotaValue> netProfit2024 = new HashMap<>();
        netProfit2024.put("YONYOU", new FiQuotaValue(new BigDecimal("1234567.8900"))); // 带尾随0，带千位分隔
        netProfit2024.put("KINGDEE", new FiQuotaValue(new BigDecimal("-54321.0"))); // 负数，带尾随0
        period2024.put("EMP_TOTAL", empTotal2024);
        period2024.put("REV_PER_EMP", revPerEmp2024);
        period2024.put("NET_PROFIT", netProfit2024);
        map.put("2024", period2024);

        // 2023 (部分数据)
        Map<String, Map<String, FiQuotaValue>> period2023 = new HashMap<>();
        Map<String, FiQuotaValue> empTotal2023 = new HashMap<>();
        empTotal2023.put("YONYOU", new FiQuotaValue(new BigDecimal("24949.00"))); // 带尾随0的整数
        // KINGDEE EMP_TOTAL 缺失
        Map<String, FiQuotaValue> revPerEmp2023 = new HashMap<>();
        revPerEmp2023.put("YONYOU", new FiQuotaValue(new BigDecimal("39.330"))); // 带尾随0
        revPerEmp2023.put("KINGDEE", new FiQuotaValue(new BigDecimal("46")));     // 整数表示
        Map<String, FiQuotaValue> netProfit2023 = new HashMap<>();
        netProfit2023.put("YONYOU", new FiQuotaValue(new BigDecimal("987654.3299991"))); // 多位小数
        // KINGDEE NET_PROFIT 缺失
        period2023.put("EMP_TOTAL", empTotal2023);
        period2023.put("REV_PER_EMP", revPerEmp2023);
        period2023.put("NET_PROFIT", netProfit2023);
        map.put("2023", period2023);

        // 2022 (更少数据)
        Map<String, Map<String, FiQuotaValue>> period2022 = new HashMap<>();
        Map<String, FiQuotaValue> empTotal2022 = new HashMap<>();
        empTotal2022.put("KINGDEE", new FiQuotaValue(new BigDecimal("12036")));
        Map<String, FiQuotaValue> netProfit2022 = new HashMap<>();
        netProfit2022.put("YONYOU", new FiQuotaValue(new BigDecimal("0.1234500"))); // 小数，带尾随0
        netProfit2022.put("KINGDEE", null); // 测试 null FiQuotaValue 的情况
        period2022.put("EMP_TOTAL", empTotal2022);
        period2022.put("NET_PROFIT", netProfit2022);
        // REV_PER_EMP 在 2022 完全缺失
        map.put("2022", period2022);


        // --- 调用转换方法 ---
        String markdownOutput = convertMapToMarkdown(map, stockCodeAndName, indicatorCodeAndName);

        // --- 打印结果 ---
        System.out.println(markdownOutput);
    }
}