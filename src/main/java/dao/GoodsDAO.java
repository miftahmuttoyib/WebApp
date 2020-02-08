package dao;

import helper.mapper.GoodsHelper;
import obj.Goods;
import org.jooq.Record;
import org.jooq.Result;

import java.util.List;

public class GoodsDAO extends DAO {
    protected List<Goods> getAll() {
        Result<Record> result = db.select().from(Goods.TABLE_NAME).fetch();
        return GoodsHelper.mapFromSelect(result);
    }
}
