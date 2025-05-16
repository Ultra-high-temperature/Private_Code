package javaTest;

public class ArabicToChineseConverter {

    // 中文数字字符，索引0-9对应零到九
    private static final String[] CN_DIGITS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    // 中文的“十”
    private static final String CN_TEN = "十";
    // 中文的“一百”
    private static final String CN_HUNDRED = "一百";

    /**
     * 将0到100之间的阿拉伯数字转换为中文数字表示。
     * 例如：
     * 0 -> "零"
     * 1 -> "一"
     * 10 -> "十"
     * 15 -> "十五"
     * 20 -> "二十"
     * 23 -> "二十三"
     * 99 -> "九十九"
     * 100 -> "一百"
     *
     * @param number 需要转换的阿拉伯数字，范围应为 0 到 100。
     * @return 对应的中文数字字符串。如果数字超出支持范围，则返回错误提示信息。
     */
    public String convertToChinese(int number) {
        // 校验输入范围
        if (number < 0 || number > 100) {
            return "输入数字超出范围 (应为0-100)";
        }

        // 特殊处理：0
        if (number == 0) {
            return CN_DIGITS[0]; // "零"
        }

        // 特殊处理：100
        if (number == 100) {
            return CN_HUNDRED; // "一百"
        }

        // 处理 1 到 99 的数字
        int tens = number / 10;  // 获取十位数
        int units = number % 10; // 获取个位数

        StringBuilder chineseNumeral = new StringBuilder();

        if (tens == 0) {
            // 处理个位数 (1-9)
            // 例如： 7 -> "七"
            return CN_DIGITS[units];
        } else if (tens == 1) {
            // 处理十几 (10-19)
            // "十" (当 units == 0 时)
            // "十一", "十二", ..., "十九"
            chineseNumeral.append(CN_TEN);
            if (units > 0) {
                chineseNumeral.append(CN_DIGITS[units]);
            }
        } else {
            // 处理二十到九十九 (20-99)
            // "二十", "三十", ..., "九十"
            // "二十一", "二十二", ..., "九十九"
            chineseNumeral.append(CN_DIGITS[tens]).append(CN_TEN);
            if (units > 0) {
                chineseNumeral.append(CN_DIGITS[units]);
            }
        }

        return chineseNumeral.toString();
    }

    // 主方法，用于测试转换逻辑
    public static void main(String[] args) {
        ArabicToChineseConverter converter = new ArabicToChineseConverter();

        System.out.println("阿拉伯数字转中文数字 (0-100):");

        int[] testNumbers = {
                0, 1, 7, 10, 11, 15, 19,
                20, 21, 28, 30, 50, 76,
                90, 99, 100, -5, 101
        };

        String[] expectedChinese = {
                "零", "一", "七", "十", "十一", "十五", "十九",
                "二十", "二十一", "二十八", "三十", "五十", "七十六",
                "九十", "九十九", "一百",
                "输入数字超出范围 (应为0-100)", "输入数字超出范围 (应为0-100)"
        };

        for (int i = 0; i < testNumbers.length; i++) {
            int num = testNumbers[i];
            String actual = converter.convertToChinese(num);
            String expected = expectedChinese[i];
            System.out.printf("数字: %3d  -> 预期: %-10s | 实际: %-10s | %s%n",
                    num, expected, actual, expected.equals(actual) ? "通过" : "失败");
        }
    }
}