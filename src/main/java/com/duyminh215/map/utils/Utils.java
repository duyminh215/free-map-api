package com.duyminh215.map.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Sort.Order;

public class Utils {

    public static List<Order> getOrderFieldsOfRequest(String sortInput) {
        List<Order> sortFields = new LinkedList<Order>();
        if (isStringEmpty(sortInput)) {
            return sortFields;
        }
        String fields[] = sortInput.split(",");
        if (fields == null || fields.length == 0) {
            return sortFields;
        }
        for (String field : fields) {
            sortFields.add(detectSortAscOrDesc(field));
        }
        return sortFields;
    }

    public static Order detectSortAscOrDesc(String field) {
        if (field.contains("-")) {
            field = field.replace("-", "");
            return Order.desc(field);
        }
        return Order.asc(field);
    }

    public static long getUnixTimeInSecond() {
        return System.currentTimeMillis() / 1000L;
    }

    public static boolean isStringEmpty(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
