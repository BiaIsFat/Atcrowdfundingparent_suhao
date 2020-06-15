package com.suhao.atcrowdfunding.util;

/**
 * @author suhao
 * @create_date 2020-05-20 12:21
 */
public class StringUtil {

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);  //     s == null | s.equals("");  //位与,逻辑与区别,非空字符串放置在前面,避免空指针
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}

