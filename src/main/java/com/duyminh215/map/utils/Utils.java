package com.duyminh215.map.utils;

import java.util.LinkedList;
import java.util.List;

import com.duyminh215.map.constant.DistanceUnitConstants;
import com.duyminh215.map.constant.GraphHopperConstants;
import com.duyminh215.map.constant.TimeUnitConstants;
import org.springframework.data.domain.Sort.Order;

public class Utils {

    public static List<Order> getOrderFieldsOfRequest(String sortInput) {
        List<Order> sortFields = new LinkedList<>();
        if (isStringEmpty(sortInput)) {
            return sortFields;
        }
        String[] fields = sortInput.split(",");
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
        if (string == null) {
            return true;
        }
        return string.trim().isEmpty();
    }

    public static String convertNumberOfSecondToDisplayTime(long second){
        if(second < TimeUnitConstants.NUMBER_SECOND_PER_MINUTE){
            return second + TimeUnitConstants.UNIT_SECOND;
        }
        long numberOfMinute = second/TimeUnitConstants.NUMBER_SECOND_PER_MINUTE;
        long numberOfSecondRemain = second - numberOfMinute * TimeUnitConstants.NUMBER_SECOND_PER_MINUTE;
        if(numberOfMinute < TimeUnitConstants.NUMBER_MINUTE_PER_HOUR){
            return numberOfMinute + TimeUnitConstants.UNIT_MINUTE + " " +
                    numberOfSecondRemain + TimeUnitConstants.UNIT_SECOND;
        }
        long numberOfHour = numberOfMinute/TimeUnitConstants.NUMBER_MINUTE_PER_HOUR;
        long numberOfMinuteRemain = numberOfMinute - numberOfHour * TimeUnitConstants.NUMBER_MINUTE_PER_HOUR;
        return numberOfHour + TimeUnitConstants.UNIT_HOUR + " " +
                numberOfMinuteRemain + TimeUnitConstants.UNIT_MINUTE + " " +
                numberOfSecondRemain + TimeUnitConstants.UNIT_SECOND;
    }

    public static String convertNumberOfMeterToDisplayDistance(double m){
        if(m < DistanceUnitConstants.NUMBER_OF_METER_PER_KILOMETER){
            return m + DistanceUnitConstants.UNIT_METER;
        }
        double numberOfKm = Math.floor(m / DistanceUnitConstants.NUMBER_OF_METER_PER_KILOMETER);
        double numberOfMeterRemain = m - numberOfKm * DistanceUnitConstants.NUMBER_OF_METER_PER_KILOMETER;
        return numberOfKm + DistanceUnitConstants.UNIT_KILOMETER + " " +
                numberOfMeterRemain + DistanceUnitConstants.UNIT_METER;
    }

    public static String getTravelModeByVehicle(String vehicle){
        if(GraphHopperConstants.PROFILE_CAR.equals(vehicle) ||
                GraphHopperConstants.PROFILE_MOTORCYCLE.equals(vehicle)){
            return GraphHopperConstants.TRAVEL_MODE_DRIVING;
        }
        if(GraphHopperConstants.PROFILE_BIKE.equals(vehicle)){
            return GraphHopperConstants.TRAVEL_MODE_BICYCLING;
        }
        if(GraphHopperConstants.PROFILE_FOOT.equals(vehicle)){
            return GraphHopperConstants.TRAVEL_MODE_WALKING;
        }
        return "";
    }
}
