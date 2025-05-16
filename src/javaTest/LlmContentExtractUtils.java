package javaTest;



import com.sun.xml.internal.ws.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LlmContentExtractUtils {


    public static final String info = "【流】大模型流式消息汇总：<think>\n" +
            "好，我现在需要分析这家农林牧渔企业的财务健康状况。首先，我得仔细阅读用户提供的数据和要求，确保理解正确。\n" +
            "\n" +
            "用户提供了六个核心指标：资产负债率、净资产收益率ROE、净利率、营业利润率、毛利率和总资产报酬率ROA。每个指标都有行业均值和本企业的数据，但ROE的本企业值是“-”，可能表示未提供或不适用。\n" +
            "\n" +
            "接下来，我需要按照用户的要求，分步骤进行分析。\n" +
            "\n" +
            "第一步，与行业均值对比。我逐一查看每个指标，比较本企业的数值与行业均值。例如，资产负债率48.60%低于行业均值52.35%，说明企业财务杠杆较低，偿债压力较小。净利率17.50%远高于行业均值-0.47%，显示企业盈利能力强。营业利润率和毛利率同样远高于行业均值，说明企业在成本控制和定价方面表现优异。总资产报酬率ROA高达224.27%，远超行业均值1.24%，显示企业资产使用效率极高。\n" +
            "\n" +
            "第二步，与具体企业对比。用户没有提供具体竞争对手的数据，所以这部分可能无法完成。但根据用户提供的数据，我只能进行行业均值的对比，无法进行具体企业的分析。\n" +
            "\n" +
            "第三步，识别关键短板。从数据来看，ROE为“-”，可能意味着企业没有提供该数据，或者该指标表现不佳。ROE是衡量股东回报的重要指标，如果该值为负或低于行业均值，可能意味着企业盈利能力不足或权益回报率低。因此，ROE可能是企业的关键短板之一。\n" +
            "\n" +
            "第四步，制定改善策略。短期策略方面，可以考虑优化资本结构，提高ROE；加强成本控制，进一步提升毛利率；优化资产使用效率，提高ROA。长期策略方面，可以考虑拓展高附加值业务，提升整体盈利能力；加强研发投入，提高产品竞争力，从而提升ROE和毛利率。\n" +
            "\n" +
            "最后，数据来源部分，用户提到行业均值来自申万行业分类下所有上市公司近3年年报的算术平均值，但没有提供具体对标企业的数据，因此这部分可能需要进一步补充。\n" +
            "\n" +
            "总结来说，企业整体财务状况良好，但ROE可能是一个需要关注的短板，需要通过优化资本结构和提升盈利能力来改善。\n" +
            "</think>\n" +
            "\n" +
            "<summary>\n" +
            "## 核心问题总结与建议\n" +
            "1. 核心问题\n" +
            "   - 本企业在资产负债率、净利率、营业利润率、毛利率和总资产报酬率ROA方面表现优异，但净资产收益率ROE（平均）数据缺失，可能反映企业在股东权益回报方面存在潜在问题。\n" +
            "2. 改进建议\n" +
            "   - 短期策略：优化资本结构，提升净资产收益率；加强成本控制，进一步提升毛利率；优化资产使用效率，提高总资产报酬率。\n" +
            "   - 长期策略：拓展高附加值业务，提升整体盈利能力；加强研发投入，提高产品竞争力。\n" +
            "</summary>\n" +
            "\n" +
            "## 与行业均值对比分析\n" +
            "1. 优异指标\n" +
            "   - 资产负债率：48.60% vs 行业均值52.35% （-3.75%）\n" +
            "   - 净利率：17.50% vs 行业均值-0.47% （+17.97%）\n" +
            "   - 营业利润率：20.28% vs 行业均值-0.31% （+20.59%）\n" +
            "   - 毛利率：33.33% vs 行业均值16.21% （+17.12%）\n" +
            "   - 总资产报酬率ROA：224.27% vs 行业均值1.24% （+223.03%）\n" +
            "\n" +
            "2. 待改善指标\n" +
            "   - 净资产收益率ROE（平均）：- vs 行业均值0.45% （数据缺失）\n" +
            "\n" +
            "## 与具体企业对比分析\n" +
            "1. 优异指标\n" +
            "   - 由于未提供具体对标企业的数据，无法进行对比分析。\n" +
            "\n" +
            "2. 待改善指标\n" +
            "   - 同上，无法进行对比分析。\n" +
            "\n" +
            "## 对标数据来源\n" +
            "行业均值数据来源于申万行业分类下所有上市公司近3年年报的算术平均值。。\n" +
            "。搜索出的chunkIds：null 。使用的知识库引用信息为[]";

//    private static final Log log = LogFactory.getLog(LlmContentExtractUtils.class);
    private static final String JSON_REGEX = "```json(.*?)```";
    private static final Pattern JSON_PATTERN = Pattern.compile(JSON_REGEX, Pattern.DOTALL);

    private static final Pattern SUMMARY_PATTERN = Pattern.compile("<summary>(.*?)</summary>", Pattern.DOTALL);


    private LlmContentExtractUtils(){}

    public static String extractJson(String input){
//        if (StringUtils.isBlank(input)) {
//            return StringUtils.getEmpty();
//        }
        Matcher matcher = JSON_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            return input;
        }
    }

    /**
     * 截取 </think> 后面的内容
     * @param input 输入的字符串
     * @return </think> 后面的内容，如果未找到 </think> 则返回空字符串
     */
    public static String extractContentAfterThink(String input) {
        if (input == null) {
            return "";
        }
        int index = input.indexOf("</think>");
        if (index != -1) {
            return input.substring(index + "</think>".length()).trim();
        }
        return input;
    }

//    public static String extractContent(String data) {
////        if (StringUtils.isBlank(data)) {
////            return "";
////        }
//        JsonObject jsonObject;
//        try {
//            jsonObject = JsonObject.parse(data);
//        } catch (Exception e) {
//            return "";
//        }
//
//        JsonArray choices = jsonObject.getJsonArray("choices");
//        if (CollectionUtils.isEmpty(choices)) {
//            return "";
//        }
//
//        JsonObject choice = choices.getJsonObject(0);
//
//        JsonObject message = choice.getJsonObject("message");
//        if (message == null) {
//            return "";
//        }
//
//        return message.getString("content");
//    }
//
//    public static String extractStreamContent(String streamContent) {
//        if (streamContent.startsWith("data:")) {
//            streamContent = streamContent.replaceFirst("data: ", "").trim();
//        }
//        streamContent = streamContent.trim();
//
//        if (StringUtils.isEmpty(streamContent)) {
//            return "";
//        }
//
//        log.info("streamContent json:{}", streamContent);
//
//        JsonObject contentObj = JsonObject.parse(streamContent);
//
//        JsonArray choicesArr = contentObj.getJsonArray("choices");
//        JsonObject choice = choicesArr.getJsonObject(0);
//        JsonObject delta = choice.getJsonObject("delta");
//
//        return delta.getString("content");
//    }

    public static String extractSummaryContent(String input) {
        Matcher matcher = SUMMARY_PATTERN.matcher(input);
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

    public static String extractMsgContent(String llmResponse) {
        String summarySymbol = "</summary>";
        if (llmResponse.contains(summarySymbol)) {
            String[] split = llmResponse.split(summarySymbol);
            return split[1];
        }
        return llmResponse;
    }

    public static void main(String[] args) {
        String s = extractMsgContent(info);
        String s1 = extractSummaryContent(info);
    }
}
