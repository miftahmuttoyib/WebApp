package bo;

import obj.Goods;

import java.util.List;

public interface GoodsBO {
    Goods getById(String id);
    List<Goods> getAllGoods();
}
