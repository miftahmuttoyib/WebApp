package dao;

import obj.Goods;

import java.util.List;

public class GoodsDAO extends DAO {
    protected List<Goods> getAll() {
        //        return GoodsHelper.mapFromSelect(result);
        return db.select().from(Goods.TABLE_NAME).fetch().into(Goods.class);
    }
}
