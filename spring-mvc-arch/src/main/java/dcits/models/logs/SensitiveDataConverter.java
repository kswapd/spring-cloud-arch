package dcits.models.logs;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;

public class SensitiveDataConverter extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        // 获取脱敏后的日志
        return invokeMsg(event.getFormattedMessage());
    }

    /**
     * 日志脱敏开关
     */
    public static String converterCanRun = "true";

    /**
     * 日志脱敏关键字
     */
    public static Map<String, String> sensitiveDataKeys = new ConcurrentHashMap<>();


    @PostConstruct
    public void init()
    {
        sensitiveDataKeys.put("baseAcctName","name");
        sensitiveDataKeys.put("baseAcctNo","idCardNum");
        sensitiveDataKeys.put("pwd","defaultType");
        sensitiveDataKeys.put("mobile","mobilePhone");
    }

    /**
     * 处理日志字符串，返回脱敏后的字符串
     *
     * @param oriMsg
     * @return
     */

    public String invokeMsg(final String oriMsg) {
        String tempMsg = oriMsg;
        if (sensitiveDataKeys.isEmpty()) {
            sensitiveDataKeys.put("baseAcctName","name");
            sensitiveDataKeys.put("baseAcctNo","idCardNum");
            sensitiveDataKeys.put("pwd","defaultType");
            sensitiveDataKeys.put("mobile","mobilePhone");
        }
        if ("true".equals(converterCanRun)) {
            // 处理字符串
            if (!sensitiveDataKeys.isEmpty()) {
                Set<String> keySet = sensitiveDataKeys.keySet();
                for (String key : keySet) {
                    int index = -1;
                    do {
                        index = tempMsg.indexOf(key, index + 1);
                        if (index != -1) {
                            // 判断key是否为单词字符
                            if (isWordChar(tempMsg, key, index)) {
                                continue;
                            }
                            // 寻找值的开始位置
                            int valueStart = getValueStartIndex(tempMsg, index + key.length());
                            // 查找值的结束位置（逗号，分号）
                            int valueEnd = getValuEndEIndex(tempMsg, valueStart);
                            // 对获取的值进行脱敏 
                            String subStr = tempMsg.substring(valueStart, valueEnd);
                            subStr = sensitive(subStr, key);
                            tempMsg = tempMsg.substring(0, valueStart) + subStr + tempMsg.substring(valueEnd);
                        }
                    } while (index != -1);
                }
            }
        }
        return tempMsg;
    }


    private static Pattern pattern = Pattern.compile("[0-9a-zA-Z]");

    /**
     * 判断从字符串msg获取的key值是否为单词 ， index为key在msg中的索引值
     *
     * @return
     */
    private boolean isWordChar(String msg, String key, int index) {
        // 必须确定key是一个单词
        if (index != 0) {
            // 判断key前面一个字符
            char preCh = msg.charAt(index - 1);
            Matcher match = pattern.matcher(preCh + "");
            if (match.matches()) {
                return true;
            }
        }
        // 判断key后面一个字符
        char nextCh = msg.charAt(index + key.length());
        Matcher match = pattern.matcher(nextCh + "");
        if (match.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 获取value值的开始位置
     *
     * @param msg        要查找的字符串
     * @param valueStart 查找的开始位置
     * @return
     */
    private int getValueStartIndex(String msg, int valueStart) {
        // 寻找值的开始位置
        do {
            char ch = msg.charAt(valueStart);
            if (ch == ':' || ch == '=') {
                // key与 value的分隔符
                valueStart++;
                ch = msg.charAt(valueStart);
                if (ch == '"') {
                    valueStart++;
                }
                break;
                // 找到值的开始位置
            } else {
                valueStart++;
            }
        } while (true);
        return valueStart;
    }

    /**
     * 获取value值的结束位置
     *
     * @return
     */
    private int getValuEndEIndex(String msg, int valueEnd) {
        do {
            if (valueEnd == msg.length()) {
                break;
            }
            char ch = msg.charAt(valueEnd);

            if (ch == '"') {
                // 引号时，判断下一个值是结束，分号还是逗号决定是否为值的结束
                if (valueEnd + 1 == msg.length()) {
                    break;
                }
                char nextCh = msg.charAt(valueEnd + 1);
                if (nextCh == ';' || nextCh == ',') {
                    // 去掉前面的 \  处理这种形式的数据
                    while (valueEnd > 0) {
                        char preCh = msg.charAt(valueEnd - 1);
                        if (preCh != '\\') {
                            break;
                        }
                        valueEnd--;
                    }
                    break;
                } else {
                    valueEnd++;
                }
            } else if (ch == ';' || ch == ',' || ch == '}') {
                break;
            } else {
                valueEnd++;
            }

        } while (true);
        return valueEnd;
    }

    private String sensitive(String subMsg, String key) {
        String sensitiveType = sensitiveDataKeys.get(key);
        SensitiveUtils.sensitiveType Type = SensitiveUtils.sensitiveType.valueOf(sensitiveType);
        String valueStr = subMsg;
        //匹配注解类型
        switch (Type) {
            case name: {
                valueStr = SensitiveUtils.name(subMsg);
                break;
            }
            case idCardNum: {
                valueStr = SensitiveUtils.idCardNum(subMsg);
                break;
            }
            case mobilePhone: {
                valueStr = SensitiveUtils.mobilePhone(subMsg);
                break;
            }
            case fixedPhone: {
                valueStr = SensitiveUtils.fixedPhone(subMsg);
                break;
            }
            case defaultType: {
                valueStr = SensitiveUtils.defaultType(subMsg);
                break;
            }
            case cnapsCode: {
                valueStr = SensitiveUtils.cnapsCode(subMsg);
                break;
            }
            case bankCard: {
                valueStr = SensitiveUtils.bankCard(subMsg);
                break;
            }
        }
        return valueStr;
    }
}
