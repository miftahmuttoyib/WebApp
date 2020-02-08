package helper.mapper;

import obj.Goods;
import org.jooq.Record;
import org.jooq.Result;
import stdc.IdName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsHelper {
    public static List<Goods> mapFromSelect(Result<Record> result) {
        List<Goods> resultList = new ArrayList<>();
        for (Record item : result) {
            resultList.add(map(item));
        }
        return resultList;
    }

    private static Goods map(Record item) {
        Goods resultItem = new Goods();
        resultItem.setId((String) item.getValue(IdName.ColumnName.ID));
        resultItem.setName((String) item.getValue(IdName.ColumnName.NAME));
        resultItem.setCode((String) item.getValue(Goods.ColumnName.CODE));
        resultItem.setPrice(((BigDecimal) item.getValue(Goods.ColumnName.PRICE)).doubleValue());
        resultItem.setLocationCode((String) item.getValue(Goods.ColumnName.LOCATION_CODE));
        resultItem.setStock(((BigDecimal) item.getValue(Goods.ColumnName.STOCK)).doubleValue());
        return resultItem;
    }
}
