package helper.mapper;

import obj.Problem;
import org.jooq.Record;
import org.jooq.Result;
import stdc.IdName;

import java.util.ArrayList;
import java.util.List;

public class ProblemHelper {
    public static List<Problem> mapFromSelect(Result<Record> result) {
        List<Problem> resultList = new ArrayList<>();
        for (Record item : result) {
            resultList.add(map(item));
        }
        return resultList;
    }

    private static Problem map(Record item) {
        Problem resultItem = new Problem();
        resultItem.setId((String) item.getValue(IdName.ColumnName.ID));
        resultItem.setName((String) item.getValue(IdName.ColumnName.NAME));
        resultItem.setPriority((Integer) item.getValue(Problem.ColumnName.PRIORITY));
        resultItem.setWorkingType((String) item.getValue(Problem.ColumnName.WORKING_TYPE));
        resultItem.setExecutionTime((Integer) item.getValue(Problem.ColumnName.EXECUTION_TIME));
        return resultItem;
    }
}
