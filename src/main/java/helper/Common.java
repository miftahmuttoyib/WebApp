package helper;

import obj.Problem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Common {

    public static Date DEFAULT_DATE = new Date(1990, Calendar.JANUARY, 1);

    public static void mapWorkingType(List<Problem> resultList) {
        for (Problem item : resultList) {
            mapWorkingType(item);
        }
    }

    public static void mapWorkingType(Problem item) {
        String workingTypeCode = item.getWorkingType();
        if (workingTypeCode.equals("1")) {
            item.setWorkingType(WorkingType.ELECTRICAL.toString());
        } else {
            item.setWorkingType(WorkingType.MECHANICAL.toString());
        }
    }

    public static <T> String zeroFill(T param) {
        int temp;
        if (param instanceof String) {
            temp = Integer.parseInt((String) param);
        } else {
            temp = (int) param;
        }

        if (temp < 10) {
            return "0" + param;
        } return (String) param;
    }

    //todo
    public static <T> String zeroFill(T param, int count) {
//        int temp;
//        if (param instanceof String) {
//            param;
//
//        }
        return "";
    }
}
