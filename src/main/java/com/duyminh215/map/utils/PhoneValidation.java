package com.duyminh215.map.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidation {

    public static final String PHONE_START_VIETTEL = "96|97|98|86|32|33|34|35|36|37|38|39";
    public static final String PHONE_START_MOBI = "89|90|93|70|79|77|76|78";
    public static final String PHONE_START_VINA = "88|91|94|83|84|85|81|82";
    public static final String PHONE_START_VIETNAMMOBILE = "92|56|58|52";
    public static final String PHONE_START_GMOBILE = "99|59";

    private final static String[] OLD_PRE_FIX_PHONE_NUMBER = { "120", "121", "122", "126", "128", "123", "124", "125",
            "127", "129", "162", "163", "164", "165", "166", "167", "168", "169", "186", "188", "199" };
    private final static String[] NEW_PRE_FIX_PHONE_NUMBER = { "70", "79", "77", "76", "78", "83", "84", "85", "81",
            "82", "32", "33", "34", "35", "36", "37", "38", "39", "56", "58", "59" };

    public static String correctToPhoneNumber(String phone) {
        if (phone.startsWith("+")) {
            phone = phone.substring(1);
        }
        Pattern pattern = Pattern.compile("^[0-9\\+\\(\\)\\s]{9,}.*$");
        Matcher match = pattern.matcher(phone);
        if (match.matches()) {
            phone = phone.replaceAll("[^\\d]", "");
            pattern = Pattern.compile("^84([0-9]{8,})");
            match = pattern.matcher(phone);
            if (match.matches()) {
                phone = match.group(1);
            }
            if (phone.startsWith("0")) {
                phone = phone.substring(1);
            }
            pattern = Pattern.compile("^(" + PHONE_START_MOBI + "|" + PHONE_START_VINA + "|" + PHONE_START_VIETTEL + "|"
                    + PHONE_START_VIETNAMMOBILE + "|" + PHONE_START_GMOBILE + ")[0-9]{7}$");

            match = pattern.matcher(phone);
            if (match.matches()) {
                phone = convertPhoneNumnerOldPrefixToNewPrefix(phone);
                return phone;
            } else {
                return "";
            }
        }
        return "";
    }

    public static String convertPhoneNumnerOldPrefixToNewPrefix(String phone) {
        if (phone.length() == 10) {
            for (int i = 0; i < OLD_PRE_FIX_PHONE_NUMBER.length; i++) {
                if (phone.startsWith(OLD_PRE_FIX_PHONE_NUMBER[i])) {
                    phone = NEW_PRE_FIX_PHONE_NUMBER[i]
                            + phone.substring(OLD_PRE_FIX_PHONE_NUMBER[i].length(), phone.length());
                    break;
                }
            }
        }
        return phone;
    }

    public static boolean isValidPhone(String phone) {
        String correctPhone = correctToPhoneNumber(phone);
        if (Utils.isStringEmpty(correctPhone)) {
            return false;
        }
        return true;
    }

}
