package helper;

import obj.Problem;

import java.util.List;

public class Common {
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
}
