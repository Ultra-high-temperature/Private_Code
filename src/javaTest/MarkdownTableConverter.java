package javaTest;

import java.math.BigDecimal;
import java.math.RoundingMode; // 虽然此方案未使用显式舍入，但DecimalFormat内部有默认舍入
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MarkdownTableConverter {

    // --- 类定义 (与之前相同) ---
    public static class FiItemDataType {
        private String name;
        public FiItemDataType(String name) { this.name = name; }
        public String getName() { return name; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FiItemDataType that = (FiItemDataType) o;
            return Objects.equals(name, that.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class MarketCompanyItemValue {
        private String stockCode;
        private String quarterlyPeriod;
        private String standardRptItemNumber;
        private FiItemDataType itemDataType;
        private String itemValue;

        public MarketCompanyItemValue(String stockCode, String quarterlyPeriod, String standardRptItemNumber, FiItemDataType itemDataType, String itemValue) {
            this.stockCode = stockCode;
            this.quarterlyPeriod = quarterlyPeriod;
            this.standardRptItemNumber = standardRptItemNumber;
            this.itemDataType = itemDataType;
            this.itemValue = itemValue;
        }

        public String getStockCode() { return stockCode; }
        public void setStockCode(String stockCode) { this.stockCode = stockCode; }
        public String getQuarterlyPeriod() { return quarterlyPeriod; }
        public void setQuarterlyPeriod(String quarterlyPeriod) { this.quarterlyPeriod = quarterlyPeriod; }
        public String getStandardRptItemNumber() { return standardRptItemNumber; }
        public void setStandardRptItemNumber(String standardRptItemNumber) { this.standardRptItemNumber = standardRptItemNumber; }
        public FiItemDataType getItemDataType() { return itemDataType; }
        public void setItemDataType(FiItemDataType itemDataType) { this.itemDataType = itemDataType; }
        public String getItemValue() { return itemValue; }
        public void setItemValue(String itemValue) { this.itemValue = itemValue; }
    }




    /**
     * 将 Map 数据转换为 Markdown 表格字符串
     *
     * @param dataMap         包含数据的 Map (Key: 期间, Value: 该期间所有公司的数据列表)
     * @param stockCodeAndName 公司代码到公司名称的映射
     * @return Markdown 格式的表格字符串
     */
    public static String convertMapToCsv (
            Map<String, List<MarketCompanyItemValue>> dataMap,
            Map<String, String> stockCodeAndName) {
        if (dataMap == null || dataMap.isEmpty() || stockCodeAndName == null || stockCodeAndName.isEmpty()) {
            return ""; // 或者返回一个表示无数据的 Markdown 消息
        }

        // 1. 数据准备
        // 提取并排序期间 (降序)
        List<String> periods = dataMap.keySet().stream()
                .distinct()
                .sorted(Comparator.reverseOrder()) // 按年份降序排列，如 2024, 2023, 2022
                .collect(Collectors.toList());

        if (periods.isEmpty()) {
            return "";
        }

        // 提取所有涉及的公司代码，并保持某种固定顺序（例如按代码排序）
        List<String> stockCodes = dataMap.values().stream()
                .flatMap(List::stream) // 将所有 List<MarketCompanyItemValue> 合并成一个 Stream
                .map(MarketCompanyItemValue::getStockCode)
                .distinct()
                .sorted() // 按股票代码排序以保证顺序一致
                .collect(Collectors.toList());

        if (stockCodes.isEmpty()) {
            return "";
        }

        // 提取所有涉及的报表项目名称，并排序 (例如按名称字母顺序)
        List<String> itemNames = dataMap.values().stream()
                .flatMap(List::stream)
                .map(MarketCompanyItemValue::getStandardRptItemNumber) // 获取项目名称
                .distinct()
                .sorted() // 按项目名称排序
                .collect(Collectors.toList());

        // 2. 数据重构: ItemName -> StockCode -> Period -> Value
        // 使用 Stream API 进行分组和转换
        Map<String, Map<String, Map<String, String>>> structuredData = dataMap.entrySet().stream()
                .flatMap(entry -> {
                    String period = entry.getKey();
                    List<MarketCompanyItemValue> items = entry.getValue();
                    // 为每个 MarketCompanyItemValue 附加其所属的 Period
                    return items.stream().map(item -> new AbstractMap.SimpleImmutableEntry<>(period, item));
                }) // 得到 Stream<Entry<Period, MarketCompanyItemValue>>
                .collect(Collectors.groupingBy(
                        entry -> entry.getValue().getStandardRptItemNumber(), // 第一层分组：按报表项目名称
                        Collectors.groupingBy(
                                entry -> entry.getValue().getStockCode(),      // 第二层分组：按股票代码
                                Collectors.toMap(
                                        AbstractMap.SimpleImmutableEntry::getKey, // Map 的 Key：期间 (Period)
                                        entry -> entry.getValue().getItemValue(), // Map 的 Value：项目值 (ItemValue)
                                        (v1, v2) -> v1 // 如果同一公司、同一项目、同一期间有重复值，取第一个（或根据需要处理）
                                )
                        )
                ));

        // 3. Markdown 字符串构建
        StringBuilder markdown = new StringBuilder();

        // --- 构建表头 ---

        // 表头第一行: |报表项目|公司A| | |公司B| | |
        markdown.append("|报表项目|");
        for (String stockCode : stockCodes) {
            String companyName = stockCodeAndName.getOrDefault(stockCode, stockCode); // 获取公司名，找不到用代码代替
            markdown.append(companyName).append("|"); // 公司名称占第一列
            // 为该公司添加剩余期间的空占位符
            for (int i = 1; i < periods.size(); i++) {
                markdown.append(" |");
            }
        }
        markdown.append("\n");

        // 表头第二行 (分隔符): | ---- | ---- | ---- | ---- | ...
        markdown.append("| ---- |");
        int totalColumns = stockCodes.size() * periods.size(); // 每个公司占 periods.size() 列
        for (int i = 0; i < totalColumns; i++) {
            markdown.append(" ---- |");
        }
        markdown.append("\n");

        // 表头第三行: | |期间1|期间2|期间3|期间1|期间2|期间3| ...
        markdown.append("| |"); // “报表项目”列下为空
        for (String stockCode : stockCodes) { // 对每个公司重复期间列表
            for (String period : periods) {
                String newPeriod = Objects.equals("12", period.split("-")[1]) ? period.split("-")[0]
                        : period.split("-")[0].concat("-").concat(period.split("-")[1]);
                markdown.append(newPeriod).append("|");
            }
        }
        markdown.append("\n");

        // --- 构建数据行 ---
        for (String itemName : itemNames) {
            markdown.append("|").append(itemName).append("|"); // 第一列是报表项目名称
            for (String stockCode : stockCodes) {
                for (String period : periods) {
                    // 从重构的数据中查找值
                    String value = structuredData.getOrDefault(itemName, Collections.emptyMap())
                            .getOrDefault(stockCode, Collections.emptyMap())
                            .getOrDefault(period, ""); // 如果找不到则为空字符串
                    markdown.append(formatFinancialValue(value)).append("|");
                }
            }
            markdown.append("\n");
        }

        return markdown.toString();
    }

    /**
     * 格式化财务数值字符串：
     * 1. 添加千分位逗号。
     * 2. 丢弃多余尾0。
     * 3. 至少保留两位小数，不足补0。
     * 4. 若有效小数位超过两位，则完整保留。
     *
     * @param valueStr 原始数值字符串
     * @return 格式化后的字符串，如果无法解析则返回原始字符串
     */
    private static String formatFinancialValue(String valueStr) {
        if (valueStr == null || valueStr.isEmpty()) {
            return "";
        }

        String cleanValueStr = valueStr.replace(",", "");

        try {
            BigDecimal number = new BigDecimal(cleanValueStr);

            // 1. 丢弃多余尾0，得到最简 BigDecimal 形式
            BigDecimal strippedNumber = number.stripTrailingZeros();
            int scale = strippedNumber.scale(); // 获取有效小数位数

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            // DecimalFormat 默认的舍入模式是 RoundingMode.HALF_EVEN
            // 如果需要严格不舍入（截断）或特定舍入，需设置 formatter.setRoundingMode()
            // 但根据规则“完整保留”，只要pattern的小数位数足够，就不会发生不期望的舍入

            String pattern;
            if (scale <= 0) { // 整数 (e.g., 123, 123.0 -> scale 0)
                pattern = "#,##0.00"; // 保留两位小数 -> 123.00
            } else if (scale == 1) { // 一位有效小数 (e.g., 123.4)
                pattern = "#,##0.00"; // 保留两位小数 -> 123.40
            } else if (scale == 2) { // 两位有效小数 (e.g., 123.45)
                pattern = "#,##0.00"; // 刚好两位小数 -> 123.45
            } else { // 超过两位有效小数 (e.g., 123.456)
                // 构建 pattern 以匹配所有有效小数位
                StringBuilder patternBuilder = new StringBuilder("#,##0.");
                for (int i = 0; i < scale; i++) {
                    patternBuilder.append('0');
                }
                pattern = patternBuilder.toString(); // -> 123.456 (如果scale是3)
            }

            formatter.applyPattern(pattern);
            // 应用格式化到原始的 BigDecimal 'number'，
            // DecimalFormat会根据pattern处理尾部0的添加或去除（对于#.##0这样的pattern）
            // 或者精确显示（对于#.##0.000这样的pattern）。
            // 由于我们是根据strippedNumber的scale来精确构建pattern '0'的数量，
            // 它会按期望格式化原始的 'number'。
            return formatter.format(number);

        } catch (NumberFormatException e) {
            return valueStr; // 非数字字符串，原样返回
        }
    }


    public static void main(String[] args) {
        // --- 沿用之前的测试数据结构 ---
        FiItemDataType itemA = new FiItemDataType("报表项目A");
        FiItemDataType itemB = new FiItemDataType("报表项目B");
        FiItemDataType itemC = new FiItemDataType("小数项目C");
        FiItemDataType itemD = new FiItemDataType("文本与整数D");


        Map<String, String> stockCodeAndName = new HashMap<>();
        stockCodeAndName.put("600588", "用友");
        stockCodeAndName.put("002681", "金蝶");

        HashMap<String, List<MarketCompanyItemValue>> dataMap = new HashMap<>();

        List<MarketCompanyItemValue> data2024 = new ArrayList<>();
        data2024.add(new MarketCompanyItemValue("600588", "2024", "S001", itemA, "21283"));       // -> 21,283.00
        data2024.add(new MarketCompanyItemValue("600588", "2024", "S002", itemB, "43.0"));        // -> 43.00
        data2024.add(new MarketCompanyItemValue("002681", "2024", "S001", itemA, "12149.5"));     // -> 12,149.50
        data2024.add(new MarketCompanyItemValue("002681", "2024", "S002", itemB, "51.55"));      // -> 51.55
        data2024.add(new MarketCompanyItemValue("600588", "2024", "S003", itemC, "123.456"));     // -> 123.456
        data2024.add(new MarketCompanyItemValue("002681", "2024", "S003", itemC, "987.654300"));  // -> 987.6543
        data2024.add(new MarketCompanyItemValue("600588", "2024", "S004", itemD, "N/A"));         // -> N/A
        data2024.add(new MarketCompanyItemValue("002681", "2024", "S004", itemD, "0"));           // -> 0.00
        dataMap.put("2024-04", data2024);

        List<MarketCompanyItemValue> data2023 = new ArrayList<>();
        data2023.add(new MarketCompanyItemValue("600588", "2023", "S001", itemA, "24949.000"));  // -> 24,949.00
        data2023.add(new MarketCompanyItemValue("600588", "2023", "S002", itemB, "39.30"));      // -> 39.30
        data2023.add(new MarketCompanyItemValue("002681", "2023", "S001", itemA, "12348.1"));    // -> 12,348.10
        data2023.add(new MarketCompanyItemValue("002681", "2023", "S003", itemC, "5000.120"));   // -> 5,000.12
        dataMap.put("2023-04", data2023);


        String markdownOutput = convertMapToCsv(dataMap, stockCodeAndName);
        System.out.println("--- Markdown Table Output ---");
        System.out.println(markdownOutput);

        System.out.println("\n--- Einzelne FormatFinancialValue Tests ---");
        String[] testValues = {
                "123", "123.0", "123.00", "123.000", // Sollte 123.00
                "123.4", "123.40", "123.400",       // Sollte 123.40
                "123.45", "123.450", "123.4500",    // Sollte 123.45
                "123.456", "123.4560", "123.45600", // Sollte 123.456
                "0.12345", "0.123450",             // Sollte 0.12345
                "0", "0.0", "0.000",               // Sollte 0.00
                "1234567.89",                      // Sollte 1,234,567.89
                "1234567",                         // Sollte 1,234,567.00
                "N/A", "", null, "Text",
                "1,234.560" // mit Komma Input     // Sollte 1,234.56
        };

        for (String tv : testValues) {
            System.out.println("Input: \"" + tv + "\" -> Output: \"" + formatFinancialValue(tv) + "\"");
        }
    }
}
