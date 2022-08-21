package com.utils;

/**
 * @author longzhangming
 * @title 字符串工具类
 */
public class XStringUtil {
    /**
     * 按.分隔字符串，固定分成两份
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
            strs[1] = str;
        }
        return strs;
    }
}
