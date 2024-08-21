package com.example.demo.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Tools {

    /* 唯一	UNIQUE */
    public static <T> boolean unique(List<T> items) {
        return new HashSet<>(items).size() == items.size();
    }

    /* 非空	NOT_NULL */
    public static boolean notNull(Object data) {
        return data != null;
    }

    /* 枚举	ENUM(LIST) */
    public static <KEY, VALUE> boolean keyIn(BiDirectionalMap<KEY, VALUE> map, KEY key) {
        return map.containsKey(key);
    }

    public static <KEY, VALUE> boolean valueIn(BiDirectionalMap<KEY, VALUE> map, VALUE value) {
        return map.containsValue(value);
    }

    /* 字符串长度范围 STRING RANGE(MIN, MAX) */
    public static boolean stringRange(String text, int min, int max) {
        return text.length() >= min && text.length() <= max;
    }

    /* 整数类型范围 INTEGER RANGE(MIN, MAX) */
    public static boolean integerRange(Integer number, int min, int max) {
        return number >= min && number <= max;
    }

    /* 浮点类型范围 FLOAT(MIN, MAX) */
    public static boolean floatRange(Double number, float min, float max) {
        return number >= min && number <= max;
    }

    /* 以...开头 START WITH(PREFIX) */
    public static boolean startsWith(String text, String prefix) {
        return text.startsWith(prefix);
    }

    /* 以...结尾 END WITH(SUFFIX) */
    public static boolean endsWith(String text, String suffix) {
        return text.endsWith(suffix);
    }

    /* 包含关系	CONTAINS(KEYWORD) */
    public static boolean contains(String text, String keyword) {
        return text.contains(keyword);
    }

    /* 不包含关系 NOT CONTAINS(KEYWORD) */
    public static boolean notContains(String text, String keyword) {
        return !contains(text, keyword);
    }

    /* 正则匹配 REGULAR EXPRESSION(PATTERN) */
    public static boolean regexp(String text, String pattern) {
        return text.matches(pattern);
    }
}
