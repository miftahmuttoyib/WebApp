package dao;

import obj.Goods;
import obj.Problem;

import java.util.List;

public class ProblemDAO extends DAO {
    protected List<Problem> getAll() {
        //        return GoodsHelper.mapFromSelect(result);
        return db.select().from(Problem.TABLE_NAME).fetch().into(Problem.class);
    }
}
