package com.onlinebank.Utils;

import java.util.HashMap;

public class Filter {
    public static HashMap add(String operator, String col, String value) {
        HashMap _filter1 = new HashMap();

        _filter1.put("operator", operator);
        _filter1.put("col", col);
        _filter1.put("value", value);

        return _filter1;
    }

    public static HashMap add(String operator, String col, Integer value) {
        HashMap _filter1 = new HashMap();

        _filter1.put("operator", operator);
        _filter1.put("col", col);
        _filter1.put("value", value);

        return _filter1;
    }
    public static HashMap add(String operator, String col, Boolean value) {
        HashMap _filter1 = new HashMap();

        _filter1.put("operator", operator);
        _filter1.put("col", col);
        _filter1.put("value", value);

        return _filter1;
    }


}