package dcits.models.logs;


import dcits.controllers.GreetingController;
import java.lang.reflect.Field;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 脱敏工具类
 *
 * @author Tim
 * @date 2018年5月21日 下午5:44:17
 */
public class SensitiveUtils {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveUtils.class);

    /**
     * 脱敏枚举类
     *
     * @author Tim
     * @date 2018年5月21日 下午5:44:39
     */
    public enum sensitiveType {
        name, idCardNum, mobilePhone, bankCard, cnapsCode, fixedPhone, defaultType;
    }


    public static String rfillStr(String str, int len, String fillStr) {
        // modify for sonar
        StringBuilder sb = new StringBuilder().append(str);
        for (int i = 0; i < (len - str.length()); i++) {
            sb.append(fillStr);
        }
        return sb.toString();
    }

    public static String lfillStr(String str, int len, String fillStr) {
        // modify for sonar
        StringBuilder sb = new StringBuilder().append(str);
        for (int i = 0; i < (len - str.length()); i++) {
            sb.insert(0, fillStr);
        }
        return sb.toString();
    }

    //定长报文补长
    public static String pd(String str, String lr, String pd, int length) {
        if (pd.length() != 1) {
            logger.info("补位字符只能为一个字符");
        }
        int strLength = str.length();
        if (strLength > length)
            logger.info("字符串长度超过指定长度");
        if (length == strLength)
            return str;
        int pdCount = length - strLength;
        StringBuffer sb = new StringBuffer();
        if ("R".equals(lr)) {
            sb.append(str);
        }
        for (int i = 0; i < pdCount; i++) {
            sb.append(pd);
        }
        if ("L".equals(lr)) {
            sb.append(str);
        }
        return sb.toString();
    }
    /**
     * 用户名：只显示第一个，其他隐藏为星号<例子：李**>
     *
     * @param ss
     * @return 2018年5月21日 下午5:40:29
     */
    public static String name(String ss) {
        if (StringUtils.isBlank(ss)) {
            return "";
        }
        int length = ss.length();
        String newStr = ss.substring(0, 1);
        return rfillStr(newStr, length, "*");
    }

    /**
     * 默认全部字符串转换为* <例子：1234 ----》 **** >
     *
     * @param strDefault
     * @return
     * @author Tim
     * @date 2016年9月9日 下午2:36:55
     */
    public static String defaultType(String strDefault) {
        return strDefault.replaceAll("(.)", "*");

    }

    /**
     * 身份证号码：显示最后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
     *
     * @param id
     * @return 2018年5月21日 下午5:39:27
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        int length = id.length();
        if (length <= 10) {
            return id;
        }
        String num = id.substring(length - 4, length);
        return lfillStr(num, length, "*");
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     *
     * @param num 手机号码
     * @return
     * @author Tim
     * @date 2018年5月21日 下午5:47:06
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        int length = num.length();
        if (11 != length) {
            return num;
        }
        return num.substring(0, 3) + "******" + num.substring(7, 11);
    }

    /**
     * 参数类型是Integer（长度值小于11位）
     * [固定电话] 后四位，其他隐藏<例子：****1234>
     *
     * @param num
     * @return
     * @author Tim
     * @date 2016年9月9日 上午10:35:23
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        int length = num.length();
        if (length <= 4) {
            return num;
        }
        String id = num.substring(length - 4, length);
        return lfillStr(id, length, "*");
    }

    /**
     * [银行卡号] 前六位，后四位，其他用星号隐藏每位1个星号<例子:622600**********1234>
     *
     * @param cardNum 银行卡号
     * @return
     * @author Tim
     * @date 2018年5月21日 下午5:48:26
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        int length = cardNum.length();
        if (length <= 10) {
            return cardNum;
        }
        return cardNum.substring(0, 3) + lfillStr("", length, "*") + cardNum.substring(length - 4, length);
    }

    /**
     * [公司开户银行联号] 公司开户银行联行号,显示前两位，其他用星号隐藏，每位1个星号<例子:12********>
     *
     * @param code 公司开户银行联号
     * @return
     * @author Tim
     * @date 2018年5月21日 下午5:50:10
     */
    public static String cnapsCode(String code) {
        if (StringUtils.isBlank(code)) {
            return "";
        }
        int length = code.length();
        if (length <= 2) {
            return code;
        }
        return rfillStr(code.substring(0, 2), length - 2, "*");
    }


    /**
     * 获取脱敏对象
     *
     * @param object
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws Exception                2018年5月21日 下午5:41:16
     */
    public static String getJavaBean(Object object) throws
            IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Class<? extends Object> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        //获取字段上的注解
        SensitiveInfo annotation;
        //获取字段的属性名称
        String fieldName;//获取字段的值并转换为String类型
        String value;
        Field field;
        String valueStr;
        for (int i = 0; i < fields.length; i++) {
            field = fields[i];
            field.setAccessible(true);
            //获取字段上的注解
            annotation = field.getAnnotation(SensitiveInfo.class);
            fieldName = field.getName();
            value = fieldType(object, field, fieldName);
            valueStr = value;
            //判断是否存在注解
            if (null != annotation) {
                //获取注解的具体类型
                sensitiveType Type = annotation.Type();
                //匹配注解类型
                switch (Type) {
                    case name: {
                        valueStr = SensitiveUtils.name(value);
                        break;
                    }
                    case idCardNum: {
                        valueStr = SensitiveUtils.idCardNum(value);
                        break;
                    }
                    case mobilePhone: {
                        valueStr = SensitiveUtils.mobilePhone(value);
                        break;
                    }
                    case fixedPhone: {
                        valueStr = SensitiveUtils.fixedPhone(value);
                        break;
                    }
                    case bankCard: {
                        valueStr = SensitiveUtils.bankCard(value);
                        break;
                    }
                    case cnapsCode: {
                        valueStr = SensitiveUtils.cnapsCode(value);
                        break;
                    }
                    default: {
                        valueStr = SensitiveUtils.defaultType(value);
                        break;
                    }
                }
            }
            if (i == fields.length - 1) {
                sb.append(fieldName + "=" + valueStr);
            } else {
                sb.append(fieldName + "=" + valueStr + ",");
            }
        }
        return sb.append("}").toString();
    }

    private static String fieldType(Object object, Field field, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        //通过属性名获取私有属性字段的属性值
        Field f1 = object.getClass().getDeclaredField(fieldName);
        f1.setAccessible(true);
        Object valueObj = f1.get(object);
        if (null == valueObj) {
            return null;
        }
        return f1.get(object).toString();
    }
}
