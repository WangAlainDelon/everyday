package juc.threadLocal;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description
 *
 * @author chenxiuhong 2020/04/22 5:13 下午
 */
public class HarborUtil {
    private static Random random;

    static {
        try {
            // https://segmentfault.com/a/1190000039268233
            // ??? SecureRandom  在linux阻塞？？？？？？？
            // https://blog.csdn.net/weixin_35973521/article/details/116813890
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
        }
    }


    /***
     * 获得整数
     * @param size
     * @return
     */
    public static Map<String, Object> getStorageNumUnit(Long size) {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return storageMap(size, "B");
        } else {
            size = size / 1024;
        }

        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        if (size < 1024) {
            return storageMap(size, "KB");
        } else {
            size = size / 1024;
        }

        if (size < 1024) {
            return storageMap(size, "MB");
        } else {
            size = size / 1024;
        }

        if (size < 1024) {
            return storageMap(size, "GB");
        } else {
            size = size / 1024;
        }

        return storageMap(size, "TB");
    }

    /***
     * 保存两位小数
     * @param num
     * @return
     */
    public static Map<String, Object> getUsedStorageNumUnit(Long num) {
        BigDecimal size = new BigDecimal(num);

        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size.doubleValue() < 1024) {
            return storageMap(size, "B");
        } else {
            size = size.divide(new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
        }

        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        if (size.doubleValue() < 1024) {
            return storageMap(size, "KB");
        } else {
            size = size.divide(new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
        }

        if (size.doubleValue() < 1024) {
            return storageMap(size, "MB");
        } else {
            size = size.divide(new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
        }

        if (size.doubleValue() < 1024) {
            return storageMap(size, "GB");
        } else {
            size = size.divide(new BigDecimal(1024), 2, BigDecimal.ROUND_HALF_UP);
        }

        return storageMap(size, "TB");
    }

    public static Map<String, Object> storageMap(Object storageNum, Object storageUnit) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("storageNum", storageNum);
        map.put("storageUnit", storageUnit);
        return map;
    }

    public static String getTagSizeDesc(Long size) {
        Map<String, Object> sizeMap = getUsedStorageNumUnit(size);
        BigDecimal storageNum = (BigDecimal) sizeMap.get("storageNum");
        String storageUnit = (String) sizeMap.get("storageUnit");
        return storageNum + storageUnit;
    }

    public static Date timestampToDate(Map<String, Object> whiteMap) {
        if (whiteMap == null) {
            return null;
        }

        Double doubleExpire = (Double) whiteMap.get("expires_at");
        if (doubleExpire == null) {
            return null;
        }
        String expire = String.valueOf((doubleExpire).longValue());

        Date endDate = new Date(Long.parseLong(expire + "000"));
        return endDate;
    }

    public static Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime() / 1000;
    }


    /***
     * 校验字符串是否在值区间内
     * @param str 字符串
     * @param fieldName 字段名
     * @param errorMsgCode 消息code
     * @param args 参数
     */


    /***
     * size转GB、TB等
     * @param size
     * @return
     */
    public static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.##").format(size / Math.pow(1024, digitGroups)) + "/" + units[digitGroups];
    }






    /**
     * 随机生成长度为len的密码，且包括大写、小写英文字母和数字
     *
     * @author xuhui
     */

    static char[] bigNum = new char[26];
    static char[] smallNum = new char[26];
    static int[] num = new int[10];

    public static String getPassword() {
        String str;
        do {
            str = getPassString();
        } while (!testExistLowerCase(str) || !testExistUpperCase(str) || !isContainNumber(str));
        return str;
    }

    private static String getPassString() {
        int len = 8;
        String str = "";
        init();
        //需要先随机生成len长度中，大写字母的个数，小写字母的个数以及数字的个数，且保证每个个数都不能为0
        int big_len = random.nextInt(len - 2) + 1;
        int small_len = random.nextInt(len - big_len - 1) + 1;
        int num_len = len - big_len - small_len;
        //每一位生成对应的密码
        for (int i = 0; i < big_len; i++) {
            str += bigNum[random.nextInt(26)];
        }
        for (int i = 0; i < small_len; i++) {
            str += smallNum[random.nextInt(26)];
        }
        for (int i = 0; i < num_len; i++) {
            str += num[random.nextInt(10)];
        }
        return str;
    }

    /**
     * 字符串是否存在大写字母
     *
     * @param word
     * @return
     */
    public static boolean testExistUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否存在小写字母
     *
     * @param word
     * @return
     */
    public static boolean testExistLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 字符串是否存在数字
     *
     * @param company
     * @return
     */
    public static boolean isContainNumber(String company) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(company);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static void init() {
        //生成大写字母表,对照ASIC表
        for (int i = 65; i <= 90; i++) {
            bigNum[i - 65] = (char) i;
        }
        //生成小写字母表
        for (int i = 97; i <= 122; i++) {
            smallNum[i - 97] = (char) i;
        }
        //生成数字表
        for (int i = 0; i <= 9; i++) {
            num[i] = i;
        }
    }

}
