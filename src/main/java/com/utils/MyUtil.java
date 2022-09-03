package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * @title 一些常用的工具方法
 */
public class MyUtil {

    /*获取字符串***********************************************/
    /**
     * 获取UUID类型的字符串
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    static AtomicInteger seed = new AtomicInteger(0);
    /**
     * 获取数字类型的字符串，不重复
     * @return
     */
    public static String getUUID2(){
        int s = seed.incrementAndGet() % 10;
        return System.currentTimeMillis() + "" + s;
    }

    /**
     * 返回随机字符串,可指定长度，会重复
     * @param length 长度
     * @return
     */
    public static String getRandomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++){
            sb.append(str.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    /*工具方法***********************************************/
    private static Pattern patternNumberPattern = Pattern.compile("[0-9]*");
    /**
     * 验证一个str是否为整数
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        return patternNumberPattern.matcher(str).matches();
    }

    /**
     * 验证一个str是否为数字类型
     * @param str
     * @return
     */
    public static boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e1) {
                try {
                    Float.parseFloat(str);
                    return true;
                } catch (NumberFormatException e2) {
                    try {
                        Long.parseLong(str);
                        return true;
                    } catch (NumberFormatException e3) {
                        return false;
                    }
                }
            }
        }
    }

    /**
     * 将字符串转化为指定数据类型
     * @param str
     * @param cs
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T>T getObjectByClass(String str, Class<T> cs){
        Object value = null;
        if(str == null){
            value = null;
        }else if (cs.equals(String.class)) {
            value = str;
        } else if (cs.equals(int.class)||cs.equals(Integer.class)) {
            value = new Integer(str);
        } else if (cs.equals(long.class)||cs.equals(Long.class)) {
            value = new Long(str);
        } else if (cs.equals(short.class)||cs.equals(Short.class)) {
            value = new Short(str);
        } else if (cs.equals(float.class)||cs.equals(Float.class)) {
            value = new Float(str);
        } else if (cs.equals(double.class)||cs.equals(Double.class)) {
            value = new Double(str);
        } else if (cs.equals(boolean.class)||cs.equals(Boolean.class)) {
            value = new Boolean(str);
        }else{
            throw new RuntimeException("超纲的类型：" + cs + "，未能转换值：" + str);
        }
        return (T)value;
    }

    /**
     * 把其他类型转换成String类型
     * @param str
     * @param defult
     * @return
     */
    public static String asString(Object str, String defult){
        return str==null ? defult : str.toString();
    }

    /*日期时间相关***********************************************/
    /**
     * 获取当前日期,输入格式，如yyyy/MM/dd HH:mm:ss
     * @return 例：20210521
     */
    public static String getPresentDate(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 获取当前日期,默认格式,yyyyMMdd
     * @return 例：20210521
     */
    public static String getPresentDate(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * 获取当前时间,默认格式,HHmmss
     * @return 例：20210521
     */
    public static String getPresentTime(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前时间,默认格式
     * @return 例：20210521
     */
    public static String getPresentDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当前时间,默认格式,HHmmss
     * @return 例：20210521
     */
    public static String getPresentDateTime1(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * 字符串转换成时间
     * @param format 格式：如：yyyyMMdd
     * @param time 符合格式的字符串时间：如：20210521
     * @return
     */
    public static Date str2Date(String format, String time){
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取昨天的时间；默认格式yyyyMMdd
     * @return
     */
    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 获取昨天的时间
     * @param format 指定格式：如yyyyMMdd
     * @return
     */
    public static String getYesterday(String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 获取明天的时间
     * @return
     */
    public static String getNextday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 获取明天的时间
     * @return
     */
    public static String getNextday(String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 根据输入的日期获取明天的日期，并返回相应的格式
     * 如：输入：yyyyMMdd  20211110210000
     * 返回20211111
     * @param format 时间返回的格式:如 yyyyMMdd
     * @param date 输入的日期
     * @return
     */
    public static String getNextDay(String format,String date){
        SimpleDateFormat smdate = new SimpleDateFormat(format);
        Date dates=null;
        try {
            dates = smdate.parse(date);
        }catch (Exception e){
            return date;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dates);
        System.out.println(calendar.getTime());
        calendar.add(calendar.DATE, +1);
        String myDate = smdate.format(calendar.getTime());
        return myDate;
    }



    /**
     * 获取当月天数
     * @param format 格式：如：yyyyMMdd
     * @param time 日期字符串：如：20210521
     * @return 2021年5月的月天数，如：30
     */
    public static int getLsatDay(String format, String time){
        Date date = MyUtil.str2Date(format, time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        String format2 = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        return Integer.parseInt(format2.substring(6, 8));
    }

    /**
     * 获取当月天数,默认格式"yyyyMMdd"
     * @param time 日期字符串：如：20210521
     * @return 2021年5月的月天数，如：30
     */
    public static int getLsatDay(String time){
        Date date = MyUtil.str2Date("yyyyMMdd", time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        String format2 = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        return Integer.parseInt(format2.substring(6, 8));
    }

    /**
     * 获取下月日期
     * @param time 字符串类型时间，格式yyyyMM：如：202106
     * @return 下月日期
     * 例子：
     * 		输入：202106
     * 		返回：202107
     */
    public static String getNextMonth(String time){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMM");
        YearMonth YM = YearMonth.parse(time, sdf);
        return YM.minus(-1, ChronoUnit.MONTHS).format(sdf);
    }

    /**
     * 获取下月日期
     * @param time 字符串类型时间，格式yyyyMM：如：202106
     * @return 下月日期
     * 例子：
     * 		输入：202106
     * 		返回：202107
     */
    public static String getNextMonth1(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(time));
        cal.add(Calendar.MONTH, 1);
        return sdf.format(cal.getTime());
    }

    /**
     * 根据月份生成一个月的日期数组1号-月末
     * @param datePrc 年月
     * @return 月日期数组，
     *      例：
     *      输入：202106
     *      返回：[20210601, 20210602, 20210603, ..., 20210630] ， 因为6月只有30天
     */
    public static List<String> getMonthBeginToMonthEndDateList(String datePrc) {
        if (datePrc == null || datePrc.isEmpty() || datePrc.length() != 6) {
            throw new NullPointerException("输入日期有误");
        }
        int monthDays = getLsatDay("yyyyMM", datePrc);  // 月天数，30
        List<String> list = new ArrayList<>(monthDays);
        Integer time = Integer.parseInt(datePrc + "01");    // 20210601
        for (int i = 0; i < monthDays; i++) {
            list.add(time + "");
            time ++;
        }
        return list;
    }

    /**
     * 获取当前时间到月末的每一日的日期
     * @param datePrc 当前月
     * @return 日期列表
     *      例：
     *      输入：202106，比如当前日期是20210620
     *      返回：[20210620, 20210621, 20210622, ..., 20210630] , 6月只有30天
     */
    public static List<String> getNowToMonthEndDateList(String datePrc) {
        if (datePrc == null || datePrc.isEmpty() || datePrc.length() != 6) {
            throw new NullPointerException("输入日期有误");
        }
        int monthDays = getLsatDay("yyyyMM", datePrc);  // 月天数
        String PT = getPresentDate("dd");   // 当前日
        int i1 = Integer.parseInt(PT);
        List<String> list = new ArrayList<>((monthDays + 1) - i1);
        Integer time = Integer.parseInt(datePrc + PT);    // 20210607
        for (int i = i1; i <= monthDays; i++) {
            list.add(time + "");
            time ++;
        }
        return list;
    }

    /*项目业务***********************************************/

    /**
     * 判断当前的数据是否符合修改规则，
     * 只能修改当前日期及当前日期前一天的数据
     * 后面按照那个再说，现在先按照数据创建日期
     * 符合条件：true
     * 不符合条件: false
     * @param map
     * @return
     */
    public static boolean canAlterData(Map map) {
        String datePrc = map.get("datePrc").toString().substring(0, 8); // 数据日期
        // 如果当日大于21点，那就只能导入当天的数据了，而不能导入昨天的数据
        if (getPresentDate("yyyyMMddHHmmss").compareTo(getPresentDate("yyyyMMdd")+"210000") > 0){
            if (datePrc.equals(getPresentDate())) {
                return true;
            }
        } else {
            if (datePrc.equals(getPresentDate()) || datePrc.equals(getYesterday())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 只能修改当前日期，及当前日期之后的数据，之前的不能修改
     * @param map
     * @return
     */
    public static boolean canAlterData2(Map map) {
        String datePrc = map.get("datePrc").toString().substring(0, 8); // 数据日期
        if (getPresentDate("yyyyMMddHHmmss").compareTo(getPresentDate("yyyyMMdd")+"210000") > 0){
            // 当前日期大于21点，日期往后移动一天
            if (Integer.parseInt(datePrc) >= Integer.parseInt(getNextday())) {
                return true;
            }
        } else {
            if (Integer.parseInt(datePrc) >= Integer.parseInt(getPresentDate())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据Base64编码生成图片
     * @param imgStr Base64编码字符串
     * @param imgFilePath 生成图片存放路径(全路径)
     * @return true(生成成功)/false(生成失败)
     */
    public static boolean generateImage(String imgStr, String imgFilePath) {
        // 解密
        try {
            // 解密
            Base64.Decoder decoder = Base64.getDecoder();
            // 去掉base64前缀 data:image/jpeg;base64,
            imgStr = imgStr.substring(imgStr.indexOf(",", 1) + 1, imgStr.length());
            byte[] b = decoder.decode(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 保存图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 解析 properties文件为 Map
     * @param propertiesPath
     * @return
     */
    public static Map<String, String> readPropToMap(String propertiesPath){
        Map<String, String> map = new HashMap<>();
        try {
            InputStream is = MyUtil.class.getClassLoader().getResourceAsStream(propertiesPath);
            if(is == null){
                return null;
            }
            Properties prop = new Properties();
            prop.load(is);
            for (String key : prop.stringPropertyNames()) {
                map.put(key, prop.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException("配置文件(" + propertiesPath + ")加载失败", e);
        }
        return map;
    }
}




