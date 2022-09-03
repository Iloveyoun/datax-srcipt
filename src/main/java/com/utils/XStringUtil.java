package com.utils;

/**
 * @title 字符串工具类
 */
public class XStringUtil {
    /**
     * 按.分隔字符串，从后面开始找，固定分成两份,
     * 输入：CG8TZ1.TDOBC01
     * 输出：["CG8TZ1", "TDOBC01"]
     * @param str
     * @return 分隔后的数组
     */
    public static String[] getStrArray(String str) {
        String[] strs = new String[2];
        int p1 = str.lastIndexOf('.');
        if (p1 > 0) {
            strs[0] = str.substring(0, p1);
            strs[1] = str.substring(p1 + 1);
        } else {
            strs[0] = "";
            strs[1] = str;
        }
        return strs;
    }

    /**
     * 按特定字符串分隔字符串，从前面开始找。固定分成两份
     * 输入：CG8TZ1.TDOBC01 .
     * 输出：["CG8TZ1", "TDOBC01"]
     * @param str
     * @param target
     * @return 分隔后的数组
     */
    public static String[] getStrArray(String str, String target) {
        String[] strs = new String[2];
        int p1 = str.indexOf(target);
        if (p1 > 0) {
            strs[0] = str.substring(0, p1);
            strs[1] = str.substring(p1 + 1);
        } else {
            strs[0] = "";
            strs[1] = str;
        }
        return strs;
    }
}
